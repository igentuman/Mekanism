package mekanism.common.item.gear;

import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mekanism.api.Action;
import mekanism.api.IIncrementalEnum;
import mekanism.api.chemical.gas.BasicGasTank;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.IGasHandler;
import mekanism.api.text.EnumColor;
import mekanism.api.text.IHasTextComponent;
import mekanism.client.render.item.ISTERProvider;
import mekanism.common.MekanismLang;
import mekanism.common.base.ILangEntry;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.capabilities.ItemCapabilityWrapper;
import mekanism.common.capabilities.chemical.RateLimitGasHandler;
import mekanism.common.config.MekanismConfig;
import mekanism.common.item.IItemHUDProvider;
import mekanism.common.registries.MekanismGases;
import mekanism.common.util.GasUtils;
import mekanism.common.util.ItemDataUtils;
import mekanism.common.util.MekanismUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemFlamethrower extends Item implements IItemHUDProvider {

    private final int TRANSFER_RATE = 16;

    public ItemFlamethrower(Properties properties) {
        super(properties.maxStackSize(1).setNoRepair().setISTER(ISTERProvider::flamethrower));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        boolean hasGas = false;
        if (Capabilities.GAS_HANDLER_CAPABILITY != null) {
            //Ensure the capability is not null, as the first call to addInformation happens before capability injection
            Optional<IGasHandler> capability = MekanismUtils.toOptional(stack.getCapability(Capabilities.GAS_HANDLER_CAPABILITY));
            if (capability.isPresent()) {
                IGasHandler gasHandlerItem = capability.get();
                if (gasHandlerItem.getGasTankCount() > 0) {
                    //Validate something didn't go terribly wrong and we actually do have the tank we expect to have
                    GasStack storedGas = gasHandlerItem.getGasInTank(0);
                    if (!storedGas.isEmpty()) {
                        tooltip.add(MekanismLang.STORED.translate(storedGas, storedGas.getAmount()));
                        hasGas = true;
                    }
                }
            }
        }
        if (!hasGas) {
            tooltip.add(MekanismLang.NO_GAS.translate());
        }
        tooltip.add(MekanismLang.MODE.translateColored(EnumColor.GRAY, getMode(stack)));
    }

    @Nonnull
    public GasStack useGas(ItemStack stack, int amount) {
        Optional<IGasHandler> capability = MekanismUtils.toOptional(stack.getCapability(Capabilities.GAS_HANDLER_CAPABILITY));
        if (capability.isPresent()) {
            IGasHandler gasHandlerItem = capability.get();
            return gasHandlerItem.extractGas(0, amount, Action.EXECUTE);
        }
        return GasStack.EMPTY;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return GasUtils.getDurabilityForDisplay(stack);
    }

    @Override
    public int getRGBDurabilityForDisplay(@Nonnull ItemStack stack) {
        return MathHelper.hsvToRGB(Math.max(0.0F, (float) (1 - getDurabilityForDisplay(stack))) / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public void fillItemGroup(@Nonnull ItemGroup group, @Nonnull NonNullList<ItemStack> items) {
        super.fillItemGroup(group, items);
        if (isInGroup(group)) {
            items.add(GasUtils.getFilledVariant(new ItemStack(this), MekanismConfig.general.maxFlamethrowerGas.get(), MekanismGases.HYDROGEN));
        }
    }

    public void incrementMode(ItemStack stack) {
        setMode(stack, getMode(stack).getNext());
    }

    public FlamethrowerMode getMode(ItemStack stack) {
        return FlamethrowerMode.byIndexStatic(ItemDataUtils.getInt(stack, "mode"));
    }

    public void setMode(ItemStack stack, FlamethrowerMode mode) {
        ItemDataUtils.setInt(stack, "mode", mode.ordinal());
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new ItemCapabilityWrapper(stack, RateLimitGasHandler.create(() -> TRANSFER_RATE, MekanismConfig.general.maxFlamethrowerGas::get, BasicGasTank.manualOnly,
              BasicGasTank.alwaysTrueBi, gas -> gas == MekanismGases.HYDROGEN.getGas()));
    }

    @Override
    public void addHUDStrings(List<ITextComponent> list, ItemStack stack, EquipmentSlotType slotType) {
        boolean hasGas = false;
        if (Capabilities.GAS_HANDLER_CAPABILITY != null) {
            //Ensure the capability is not null, as the first call to addInformation happens before capability injection
            Optional<IGasHandler> capability = MekanismUtils.toOptional(stack.getCapability(Capabilities.GAS_HANDLER_CAPABILITY));
            if (capability.isPresent()) {
                IGasHandler gasHandlerItem = capability.get();
                if (gasHandlerItem.getGasTankCount() > 0) {
                    //Validate something didn't go terribly wrong and we actually do have the tank we expect to have
                    GasStack storedGas = gasHandlerItem.getGasInTank(0);
                    if (!storedGas.isEmpty()) {
                        list.add(MekanismLang.FLAMETHROWER_STORED.translate(storedGas.getAmount()));
                        hasGas = true;
                    }
                }
            }
        }
        if (!hasGas) {
            list.add(MekanismLang.FLAMETHROWER_STORED.translate(MekanismLang.NO_GAS.translate()));
        }
        list.add(MekanismLang.MODE.translate(getMode(stack)));
    }

    public enum FlamethrowerMode implements IIncrementalEnum<FlamethrowerMode>, IHasTextComponent {
        COMBAT(MekanismLang.FLAMETHROWER_COMBAT, EnumColor.YELLOW),
        HEAT(MekanismLang.FLAMETHROWER_HEAT, EnumColor.ORANGE),
        INFERNO(MekanismLang.FLAMETHROWER_INFERNO, EnumColor.DARK_RED);

        private static final FlamethrowerMode[] MODES = values();
        private final ILangEntry langEntry;
        private final EnumColor color;

        FlamethrowerMode(ILangEntry langEntry, EnumColor color) {
            this.langEntry = langEntry;
            this.color = color;
        }

        @Override
        public ITextComponent getTextComponent() {
            return langEntry.translateColored(color);
        }

        @Nonnull
        @Override
        public FlamethrowerMode byIndex(int index) {
            return byIndexStatic(index);
        }

        public static FlamethrowerMode byIndexStatic(int index) {
            //TODO: Is it more efficient to check if index is negative and then just do the normal mod way?
            return MODES[Math.floorMod(index, MODES.length)];
        }
    }
}
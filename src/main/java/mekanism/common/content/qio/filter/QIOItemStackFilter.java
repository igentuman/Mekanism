package mekanism.common.content.qio.filter;

import javax.annotation.Nonnull;
import mekanism.api.NBTConstants;
import mekanism.common.content.filter.FilterType;
import mekanism.common.content.filter.IItemStackFilter;
import mekanism.common.lib.inventory.Finder;
import mekanism.common.util.NBTUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;

public class QIOItemStackFilter extends QIOFilter<QIOItemStackFilter> implements IItemStackFilter<QIOItemStackFilter> {

    private ItemStack itemType = ItemStack.EMPTY;
    public boolean fuzzyMode;

    public QIOItemStackFilter(ItemStack item) {
        itemType = item;
    }

    public QIOItemStackFilter() {
    }

    @Override
    public Finder getFinder() {
        return fuzzyMode ? Finder.item(itemType) : Finder.strict(itemType);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbtTags) {
        super.write(nbtTags);
        nbtTags.putBoolean(NBTConstants.FUZZY_MODE, fuzzyMode);
        itemType.save(nbtTags);
        return nbtTags;
    }

    @Override
    public void read(CompoundNBT nbtTags) {
        NBTUtils.setBooleanIfPresent(nbtTags, NBTConstants.FUZZY_MODE, fuzzy -> fuzzyMode = fuzzy);
        itemType = ItemStack.of(nbtTags);
    }

    @Override
    public void write(PacketBuffer buffer) {
        super.write(buffer);
        buffer.writeBoolean(fuzzyMode);
        buffer.writeItem(itemType);
    }

    @Override
    public void read(PacketBuffer dataStream) {
        fuzzyMode = dataStream.readBoolean();
        itemType = dataStream.readItem();
    }

    @Override
    public int hashCode() {
        int code = 1;
        code = 31 * code + itemType.hashCode();
        code = 31 * code + (fuzzyMode ? 1 : 0);
        return code;
    }

    @Override
    public boolean equals(Object filter) {
        return filter instanceof QIOItemStackFilter && ((QIOItemStackFilter) filter).itemType.sameItem(itemType) && ((QIOItemStackFilter) filter).fuzzyMode == fuzzyMode;
    }

    @Override
    public QIOItemStackFilter clone() {
        QIOItemStackFilter filter = new QIOItemStackFilter();
        filter.itemType = itemType.copy();
        filter.fuzzyMode = fuzzyMode;
        return filter;
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.QIO_ITEMSTACK_FILTER;
    }

    @Nonnull
    @Override
    public ItemStack getItemStack() {
        return itemType;
    }

    @Override
    public void setItemStack(@Nonnull ItemStack stack) {
        itemType = stack;
    }
}

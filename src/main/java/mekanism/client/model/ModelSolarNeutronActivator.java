package mekanism.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import javax.annotation.Nonnull;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class ModelSolarNeutronActivator extends MekanismJavaModel {

    private static final ResourceLocation ACTIVATOR_TEXTURE = MekanismUtils.getResource(ResourceType.RENDER, "solar_neutron_activator.png");
    private final RenderType RENDER_TYPE = renderType(ACTIVATOR_TEXTURE);

    private final ExtendedModelRenderer pole;
    private final ExtendedModelRenderer panel3;
    private final ExtendedModelRenderer port;
    private final ExtendedModelRenderer panel1;
    private final ExtendedModelRenderer panel2;
    private final ExtendedModelRenderer panelBase;
    private final ExtendedModelRenderer panelBraceLeft2;
    private final ExtendedModelRenderer panelBraceRight2;
    private final ExtendedModelRenderer panelBraceLeft1;
    private final ExtendedModelRenderer panelBraceRight1;
    private final ExtendedModelRenderer panelBrace;
    private final ExtendedModelRenderer bridge;
    private final ExtendedModelRenderer platform;
    private final ExtendedModelRenderer hole2;
    private final ExtendedModelRenderer hole4;
    private final ExtendedModelRenderer hole1;
    private final ExtendedModelRenderer hole3;
    private final ExtendedModelRenderer brace2;
    private final ExtendedModelRenderer tube2c;
    private final ExtendedModelRenderer tube1b;
    private final ExtendedModelRenderer tube1c;
    private final ExtendedModelRenderer tube2b;
    private final ExtendedModelRenderer tube2a;
    private final ExtendedModelRenderer tube1a;
    private final ExtendedModelRenderer conduit;
    private final ExtendedModelRenderer brace1;
    private final ExtendedModelRenderer tank;
    private final ExtendedModelRenderer laser;
    private final ExtendedModelRenderer base;
    private final ExtendedModelRenderer support1;
    private final ExtendedModelRenderer support2;
    private final ExtendedModelRenderer support3;
    private final ExtendedModelRenderer support4;
    private final ExtendedModelRenderer support5;
    private final ExtendedModelRenderer support6;
    private final ExtendedModelRenderer support7;
    private final ExtendedModelRenderer support8;
    private final ExtendedModelRenderer support9;
    private final ExtendedModelRenderer support10;
    private final ExtendedModelRenderer support11;
    private final ExtendedModelRenderer support12;
    private final ExtendedModelRenderer support13;
    private final ExtendedModelRenderer support14;
    private final ExtendedModelRenderer support15;
    private final ExtendedModelRenderer support16;
    private final ExtendedModelRenderer portConnector;
    private final ModelRenderer laserBeamToggle;

    public ModelSolarNeutronActivator() {
        super(RenderType::entityCutout);
        texWidth = 128;
        texHeight = 64;

        pole = new ExtendedModelRenderer(this, 116, 0);
        pole.addBox(0F, 0F, 0F, 4, 15, 2, false);
        pole.setPos(-2F, -5F, 6F);
        pole.setTexSize(128, 64);
        pole.mirror = true;
        setRotation(pole, 0F, 0F, 0F);
        panel3 = new ExtendedModelRenderer(this, 84, 32);
        panel3.addBox(-6F, 0F, -16F, 6, 1, 16, false);
        panel3.setPos(-2.75F, -4.95F, 8F);
        panel3.setTexSize(128, 64);
        panel3.mirror = true;
        setRotation(panel3, -0.1082104F, 0.0279253F, 0.2617994F);
        port = new ExtendedModelRenderer(this, 0, 45);
        port.addBox(0F, 0F, 0F, 8, 8, 1, false);
        port.setPos(-4F, 12F, -8.01F);
        port.setTexSize(128, 64);
        port.mirror = true;
        setRotation(port, 0F, 0F, 0F);
        panel1 = new ExtendedModelRenderer(this, 84, 32);
        panel1.mirror = true;
        panel1.addBox(0F, 0F, -16F, 6, 1, 16, true);
        panel1.setPos(2.75F, -4.95F, 8F);
        panel1.setTexSize(128, 64);
        setRotation(panel1, -0.1082104F, -0.0279253F, -0.2617994F);
        panel2 = new ExtendedModelRenderer(this, 84, 15);
        panel2.addBox(0F, 0F, -16F, 6, 1, 16, false);
        panel2.setPos(-3F, -5F, 8F);
        panel2.setTexSize(128, 64);
        panel2.mirror = true;
        setRotation(panel2, -0.1047198F, 0F, 0F);
        panelBase = new ExtendedModelRenderer(this, 28, 45);
        panelBase.addBox(0F, 1F, -16F, 6, 1, 14, false);
        panelBase.setPos(-3F, -5F, 9F);
        panelBase.setTexSize(128, 64);
        panelBase.mirror = true;
        setRotation(panelBase, -0.1047198F, 0F, 0F);
        panelBraceLeft2 = new ExtendedModelRenderer(this, 64, 15);
        panelBraceLeft2.addBox(-4F, 0.5F, -5F, 5, 1, 2, false);
        panelBraceLeft2.setPos(-3F, -5F, 9F);
        panelBraceLeft2.setTexSize(128, 64);
        panelBraceLeft2.mirror = true;
        setRotation(panelBraceLeft2, -0.1047198F, 0F, 0.2505517F);
        panelBraceRight2 = new ExtendedModelRenderer(this, 64, 15);
        panelBraceRight2.addBox(-1F, 0.5F, -5F, 5, 1, 2, false);
        panelBraceRight2.setPos(3F, -5F, 9F);
        panelBraceRight2.setTexSize(128, 64);
        panelBraceRight2.mirror = true;
        setRotation(panelBraceRight2, -0.1047198F, 0F, -0.2555938F);
        panelBraceLeft1 = new ExtendedModelRenderer(this, 64, 15);
        panelBraceLeft1.addBox(-4F, 0.5F, -15F, 5, 1, 2, false);
        panelBraceLeft1.setPos(-3F, -5F, 9F);
        panelBraceLeft1.setTexSize(128, 64);
        panelBraceLeft1.mirror = true;
        setRotation(panelBraceLeft1, -0.1047198F, 0F, 0.2505517F);
        panelBraceRight1 = new ExtendedModelRenderer(this, 64, 15);
        panelBraceRight1.addBox(-1F, 0.5F, -15F, 5, 1, 2, false);
        panelBraceRight1.setPos(3F, -5F, 9F);
        panelBraceRight1.setTexSize(128, 64);
        panelBraceRight1.mirror = true;
        setRotation(panelBraceRight1, -0.1047198F, 0F, -0.2555938F);
        panelBrace = new ExtendedModelRenderer(this, 56, 18);
        panelBrace.addBox(0F, 1.2F, -10F, 2, 2, 9, false);
        panelBrace.setPos(-1F, -5F, 8F);
        panelBrace.setTexSize(128, 64);
        panelBrace.mirror = true;
        setRotation(panelBrace, -0.1047198F, 0F, 0F);
        bridge = new ExtendedModelRenderer(this, 65, 1);
        bridge.addBox(0F, 0F, 0F, 12, 1, 13, false);
        bridge.setPos(-6F, 19F, -6F);
        bridge.setTexSize(128, 64);
        bridge.mirror = true;
        setRotation(bridge, 0F, 0F, 0F);
        platform = new ExtendedModelRenderer(this, 18, 45);
        platform.addBox(-2.5F, 1F, -2.5F, 6, 3, 6, false);
        platform.setPos(-0.5F, 8F, -2.5F);
        platform.setTexSize(128, 64);
        platform.mirror = true;
        setRotation(platform, -0.1047198F, 0F, 0F);
        hole2 = new ExtendedModelRenderer(this, 0, 6);
        hole2.addBox(1F, 0F, 0F, 1, 2, 1, false);
        hole2.setPos(-0.5F, 8F, -2.5F);
        hole2.setTexSize(128, 64);
        hole2.mirror = true;
        setRotation(hole2, -0.1047198F, 0F, 0F);
        hole4 = new ExtendedModelRenderer(this, 0, 3);
        hole4.addBox(-1F, 0F, 1F, 3, 2, 1, false);
        hole4.setPos(-0.5F, 8F, -2.5F);
        hole4.setTexSize(128, 64);
        hole4.mirror = true;
        setRotation(hole4, -0.1047198F, 0F, 0F);
        hole1 = new ExtendedModelRenderer(this, 0, 3);
        hole1.addBox(-1F, 0F, -1F, 3, 2, 1, false);
        hole1.setPos(-0.5F, 8F, -2.5F);
        hole1.setTexSize(128, 64);
        hole1.mirror = true;
        setRotation(hole1, -0.1047198F, 0F, 0F);
        hole3 = new ExtendedModelRenderer(this, 0, 6);
        hole3.addBox(-1F, 0F, 0F, 1, 2, 1, false);
        hole3.setPos(-0.5F, 8F, -2.5F);
        hole3.setTexSize(128, 64);
        hole3.mirror = true;
        setRotation(hole3, -0.1047198F, 0F, 0F);
        brace2 = new ExtendedModelRenderer(this, 0, 11);
        brace2.addBox(0F, 0F, 0F, 1, 1, 2, false);
        brace2.setPos(1F, 9.5F, -7.1F);
        brace2.setTexSize(128, 64);
        brace2.mirror = true;
        setRotation(brace2, 0.1745329F, 0F, 0F);
        tube2c = new ExtendedModelRenderer(this, 0, 9);
        tube2c.addBox(0F, 0F, 0F, 1, 1, 1, false);
        tube2c.setPos(2F, 9F, 4F);
        tube2c.setTexSize(128, 64);
        tube2c.mirror = true;
        setRotation(tube2c, 0F, 0F, 0F);
        tube1b = new ExtendedModelRenderer(this, 0, 14);
        tube1b.addBox(0F, 0F, 0F, 6, 1, 1, false);
        tube1b.setPos(-3F, 8F, 2F);
        tube1b.setTexSize(128, 64);
        tube1b.mirror = true;
        setRotation(tube1b, 0F, 0F, 0F);
        tube1c = new ExtendedModelRenderer(this, 0, 9);
        tube1c.addBox(0F, 0F, 0F, 1, 1, 1, false);
        tube1c.setPos(2F, 9F, 2F);
        tube1c.setTexSize(128, 64);
        tube1c.mirror = true;
        setRotation(tube1c, 0F, 0F, 0F);
        tube2b = new ExtendedModelRenderer(this, 0, 14);
        tube2b.addBox(0F, 0F, 0F, 6, 1, 1, false);
        tube2b.setPos(-3F, 8F, 4F);
        tube2b.setTexSize(128, 64);
        tube2b.mirror = true;
        setRotation(tube2b, 0F, 0F, 0F);
        tube2a = new ExtendedModelRenderer(this, 0, 9);
        tube2a.addBox(0F, 0F, 0F, 1, 1, 1, false);
        tube2a.setPos(-3F, 9F, 4F);
        tube2a.setTexSize(128, 64);
        tube2a.mirror = true;
        setRotation(tube2a, 0F, 0F, 0F);
        tube1a = new ExtendedModelRenderer(this, 0, 9);
        tube1a.addBox(0F, 0F, 0F, 1, 1, 1, false);
        tube1a.setPos(-3F, 9F, 2F);
        tube1a.setTexSize(128, 64);
        tube1a.mirror = true;
        setRotation(tube1a, 0F, 0F, 0F);
        conduit = new ExtendedModelRenderer(this, 48, 0);
        conduit.addBox(0F, 0F, 0F, 2, 1, 7, false);
        conduit.setPos(-1F, 9.5F, -1F);
        conduit.setTexSize(128, 64);
        conduit.mirror = true;
        setRotation(conduit, 0F, 0F, 0F);
        brace1 = new ExtendedModelRenderer(this, 0, 11);
        brace1.addBox(0F, 0F, 0F, 1, 1, 2, false);
        brace1.setPos(-2F, 9.5F, -7.1F);
        brace1.setTexSize(128, 64);
        brace1.mirror = true;
        setRotation(brace1, 0.1745329F, 0F, 0F);
        tank = new ExtendedModelRenderer(this, 0, 0);
        tank.addBox(0F, 0F, 0F, 16, 9, 16, false);
        tank.setPos(-8F, 10F, -8F);
        tank.setTexSize(128, 64);
        tank.mirror = true;
        setRotation(tank, 0F, 0F, 0F);
        laser = new ExtendedModelRenderer(this, 4, 0);
        laser.addBox(0.5F, 2.1F, -9F, 1, 2, 1, false);
        laser.setPos(-1F, -5F, 8F);
        laser.setTexSize(128, 64);
        laser.mirror = true;
        setRotation(laser, -0.1117011F, 0F, 0F);
        base = new ExtendedModelRenderer(this, 0, 25);
        base.addBox(0F, 0F, 0F, 16, 4, 16, false);
        base.setPos(-8F, 20F, -8F);
        base.setTexSize(128, 64);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        support1 = new ExtendedModelRenderer(this, 0, 0);
        support1.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support1.setPos(6.5F, 19F, -7.5F);
        support1.setTexSize(128, 64);
        support1.mirror = true;
        setRotation(support1, 0F, 0F, 0F);
        support2 = new ExtendedModelRenderer(this, 0, 0);
        support2.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support2.setPos(6.5F, 19F, 6.5F);
        support2.setTexSize(128, 64);
        support2.mirror = true;
        setRotation(support2, 0F, 0F, 0F);
        support3 = new ExtendedModelRenderer(this, 0, 0);
        support3.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support3.setPos(6.5F, 19F, -5.5F);
        support3.setTexSize(128, 64);
        support3.mirror = true;
        setRotation(support3, 0F, 0F, 0F);
        support4 = new ExtendedModelRenderer(this, 0, 0);
        support4.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support4.setPos(6.5F, 19F, -3.5F);
        support4.setTexSize(128, 64);
        support4.mirror = true;
        setRotation(support4, 0F, 0F, 0F);
        support5 = new ExtendedModelRenderer(this, 0, 0);
        support5.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support5.setPos(6.5F, 19F, -1.5F);
        support5.setTexSize(128, 64);
        support5.mirror = true;
        setRotation(support5, 0F, 0F, 0F);
        support6 = new ExtendedModelRenderer(this, 0, 0);
        support6.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support6.setPos(6.5F, 19F, 0.5F);
        support6.setTexSize(128, 64);
        support6.mirror = true;
        setRotation(support6, 0F, 0F, 0F);
        support7 = new ExtendedModelRenderer(this, 0, 0);
        support7.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support7.setPos(6.5F, 19F, 2.5F);
        support7.setTexSize(128, 64);
        support7.mirror = true;
        setRotation(support7, 0F, 0F, 0F);
        support8 = new ExtendedModelRenderer(this, 0, 0);
        support8.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support8.setPos(6.5F, 19F, 4.5F);
        support8.setTexSize(128, 64);
        support8.mirror = true;
        setRotation(support8, 0F, 0F, 0F);
        support9 = new ExtendedModelRenderer(this, 0, 0);
        support9.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support9.setPos(-7.5F, 19F, 6.5F);
        support9.setTexSize(128, 64);
        support9.mirror = true;
        setRotation(support9, 0F, 0F, 0F);
        support10 = new ExtendedModelRenderer(this, 0, 0);
        support10.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support10.setPos(-7.5F, 19F, 4.5F);
        support10.setTexSize(128, 64);
        support10.mirror = true;
        setRotation(support10, 0F, 0F, 0F);
        support11 = new ExtendedModelRenderer(this, 0, 0);
        support11.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support11.setPos(-7.5F, 19F, 2.5F);
        support11.setTexSize(128, 64);
        support11.mirror = true;
        setRotation(support11, 0F, 0F, 0F);
        support12 = new ExtendedModelRenderer(this, 0, 0);
        support12.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support12.setPos(-7.5F, 19F, 0.5F);
        support12.setTexSize(128, 64);
        support12.mirror = true;
        setRotation(support12, 0F, 0F, 0F);
        support13 = new ExtendedModelRenderer(this, 0, 0);
        support13.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support13.setPos(-7.5F, 19F, -1.5F);
        support13.setTexSize(128, 64);
        support13.mirror = true;
        setRotation(support13, 0F, 0F, 0F);
        support14 = new ExtendedModelRenderer(this, 0, 0);
        support14.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support14.setPos(-7.5F, 19F, -3.5F);
        support14.setTexSize(128, 64);
        support14.mirror = true;
        setRotation(support14, 0F, 0F, 0F);
        support15 = new ExtendedModelRenderer(this, 0, 0);
        support15.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support15.setPos(-7.5F, 19F, -5.5F);
        support15.setTexSize(128, 64);
        support15.mirror = true;
        setRotation(support15, 0F, 0F, 0F);
        support16 = new ExtendedModelRenderer(this, 0, 0);
        support16.addBox(0F, 0F, 0F, 1, 1, 1, false);
        support16.setPos(-7.5F, 19F, -7.5F);
        support16.setTexSize(128, 64);
        support16.mirror = true;
        setRotation(support16, 0F, 0F, 0F);
        portConnector = new ExtendedModelRenderer(this, 0, 14);
        portConnector.addBox(0F, 0F, 0F, 6, 1, 1, false);
        portConnector.setPos(-3F, 19F, -7.01F);
        portConnector.setTexSize(128, 64);
        portConnector.mirror = true;
        setRotation(portConnector, 0F, 0F, 0F);
        laserBeamToggle = new ModelRenderer(this, 12, 0);
        laserBeamToggle.addBox(0.5F, 4.1F, -9F, 1, 11, 1, false);
        laserBeamToggle.setPos(-1F, -5F, 8F);
        laserBeamToggle.setTexSize(128, 64);
        laserBeamToggle.mirror = true;
        setRotation(laserBeamToggle, -0.1117011F, 0F, 0F);
    }

    public void render(@Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer renderer, int light, int overlayLight, boolean hasEffect) {
        renderToBuffer(matrix, getVertexBuilder(renderer, RENDER_TYPE, hasEffect), light, overlayLight, 1, 1, 1, 1);
    }

    @Override
    public void renderToBuffer(@Nonnull MatrixStack matrix, @Nonnull IVertexBuilder vertexBuilder, int light, int overlayLight, float red, float green, float blue, float alpha) {
        render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, false);
        //TODO: Figure out if there is there supposed to be a "laser" here?
        laserBeamToggle.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha);
    }

    public void renderWireFrame(MatrixStack matrix, IVertexBuilder vertexBuilder, float red, float green, float blue, float alpha) {
        render(matrix, vertexBuilder, MekanismRenderer.FULL_LIGHT, OverlayTexture.NO_OVERLAY, red, green, blue, alpha, true);
    }

    private void render(MatrixStack matrix, IVertexBuilder vertexBuilder, int light, int overlayLight, float red, float green, float blue, float alpha, boolean wireFrame) {
        pole.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panel3.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        port.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panel1.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panel2.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panelBase.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panelBraceLeft2.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panelBraceRight2.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panelBraceLeft1.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panelBraceRight1.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        panelBrace.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        bridge.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        platform.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        hole2.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        hole4.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        hole1.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        hole3.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        brace2.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        tube2c.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        tube1b.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        tube1c.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        tube2b.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        tube2a.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        tube1a.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        conduit.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        brace1.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        tank.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        laser.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        base.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support1.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support2.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support3.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support4.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support5.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support6.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support7.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support8.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support9.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support10.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support11.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support12.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support13.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support14.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support15.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        support16.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
        portConnector.render(matrix, vertexBuilder, light, overlayLight, red, green, blue, alpha, wireFrame);
    }
}
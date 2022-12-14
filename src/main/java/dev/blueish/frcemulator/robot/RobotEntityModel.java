package dev.blueish.frcemulator.robot;

import com.jozufozu.flywheel.core.model.BlockModel;
import net.minecraft.block.Blocks;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RobotEntityModel extends EntityModel<RobotEntity> {
    private final ModelPart bb_main;

    public RobotEntityModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -6.0F, -8.0F, 10.0F, 4.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(-6.0F, -5.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(20, 20).cuboid(-8.0F, -8.0F, -4.0F, 2.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(5.0F, -5.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 20).cuboid(6.0F, -8.0F, -4.0F, 2.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(RobotEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}

package dev.blueish.frcemulator.robot;

import dev.blueish.frcemulator.client.FrcEmulatorClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RobotEntityRenderer extends MobEntityRenderer<RobotEntity, RobotEntityModel> {
    public RobotEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RobotEntityModel(context.getPart(FrcEmulatorClient.ROBOT_MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(RobotEntity entity) {
        return new Identifier("frc-emulator", "textures/robot.png");
    }
}

package dev.blueish.frcemulator.client;

import dev.blueish.frcemulator.FrcEmulator;
import dev.blueish.frcemulator.robot.RobotEntityModel;
import dev.blueish.frcemulator.robot.RobotEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FrcEmulatorClient implements ClientModInitializer {
    public static final EntityModelLayer ROBOT_MODEL_LAYER = new EntityModelLayer(new Identifier("frc-emulator", "robot"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(FrcEmulator.ROBOT_ENTITY, RobotEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ROBOT_MODEL_LAYER, RobotEntityModel::getTexturedModelData);
    }
}

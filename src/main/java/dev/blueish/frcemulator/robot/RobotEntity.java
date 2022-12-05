package dev.blueish.frcemulator.robot;

import dev.blueish.frcemulator.FrcEmulator;
import dev.blueish.frcemulator.controllers.MovementController;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

import java.util.UUID;

public class RobotEntity extends PathAwareEntity {
    public final MovementController controller;

    public RobotEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);

        controller = new MovementController(this);

        FrcEmulator.ROBOT_ENTITIES.put(UUID.randomUUID(), this);
    }
}

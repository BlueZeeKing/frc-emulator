package dev.blueish.frcemulator.robot;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class RobotEntity extends PathAwareEntity {
    public RobotEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
    }
}

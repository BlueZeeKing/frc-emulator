package dev.blueish.frcemulator.controllers;

import dev.blueish.frcemulator.robot.RobotEntity;
import edu.wpi.first.wpilibj.MotorSafety;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class MovementController extends MotorSafety {
    private final RobotEntity entity;

    public MovementController(RobotEntity entity) {
        this.entity = entity;
    }

    public void moveForward(int distance) {
        entity.move(MovementType.SELF, getMoveAngle().multiply(distance));
    }

    private Vec3d getMoveAngle() {
        return Vec3d.fromPolar(0, entity.getYaw()).normalize();
    }

    public void turn(float change) {
        float degrees = MathHelper.wrapDegrees(entity.getYaw() + change);
        entity.setYaw(degrees);
        entity.setHeadYaw(entity.getYaw());
        entity.setBodyYaw(entity.getYaw());
        entity.prevBodyYaw = degrees;
        entity.prevHeadYaw = degrees;
        entity.prevYaw = degrees;
    }

    @Override
    public void stopMotor() {

    }

    @Override
    public String getDescription() {
        return "Controls all movement for the Minecraft robot";
    }
}

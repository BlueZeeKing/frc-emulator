package dev.blueish.frcemulator.frc;

import dev.blueish.frcemulator.controllers.MovementController;
import dev.blueish.frcemulator.robot.RobotEntity;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
    private final MovementController driveController;

    public Robot(RobotEntity entity) {
        super();
        driveController = entity.controller;
    }

    @Override
    public void robotInit() {
        driveController.moveForward(1);
        driveController.turn(90);

        this.isEnabled();
    }
}

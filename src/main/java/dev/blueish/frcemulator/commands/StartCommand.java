package dev.blueish.frcemulator.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import dev.blueish.frcemulator.FrcEmulator;
import dev.blueish.frcemulator.events.CommandEvents;
import dev.blueish.frcemulator.frc.Robot;
import dev.blueish.frcemulator.mixin.RobotBaseMixin;
import dev.blueish.frcemulator.robot.RobotEntity;
import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.networktables.NetworkTablesJNI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.io.IOException;
import java.util.Optional;

public class StartCommand {
    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        RobotEntity entity = (RobotEntity) EntityArgumentType.getEntity(context, "robot");

        Thread thread = new Thread(() -> {
            try {
                NetworkTablesJNI.forceLoad();
            } catch (IOException e) {
                e.printStackTrace();
            }
            RobotBase.startRobot(() -> new Robot(entity));
        }, "Robot");

        thread.start();

        FrcEmulator.LOGGER.info(DriverStation.isEnabled());

        return 1;
    }

    public static LiteralCommandNode<ServerCommandSource> getNode() {
        return CommandManager.literal("start").then(CommandManager.argument("robot", EntityArgumentType.entity()).executes(StartCommand::run)).build();
    }
}

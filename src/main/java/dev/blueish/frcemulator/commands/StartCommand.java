package dev.blueish.frcemulator.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import dev.blueish.frcemulator.FrcEmulator;
import dev.blueish.frcemulator.events.CommandEvents;
import dev.blueish.frcemulator.robot.RobotEntity;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.io.IOException;
import java.util.Optional;

public class StartCommand {
    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        RobotEntity entity = (RobotEntity) EntityArgumentType.getEntity(context, "robot");

        CommandEvents.START.invoker().start();

        return 1;
    }

    public static LiteralCommandNode<ServerCommandSource> getNode() {
        return CommandManager.literal("start").then(CommandManager.argument("robot", EntityArgumentType.entity()).executes(StartCommand::run)).build();
    }
}

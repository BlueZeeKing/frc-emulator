package dev.blueish.frcemulator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import dev.blueish.frcemulator.commands.StartCommand;
import dev.blueish.frcemulator.events.CommandEvents;
import dev.blueish.frcemulator.robot.RobotEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrcEmulator implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger("FRC Emulator");

    public static final EntityType<RobotEntity> ROBOT_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("frc-emulator", "robot"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, RobotEntity::new).dimensions(EntityDimensions.fixed(1f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ROBOT_ENTITY, RobotEntity.createMobAttributes());

        CommandEvents.START.register(() -> {
            HttpClient client = HttpClient.newHttpClient();
            CompletableFuture<WebSocket> ws = client.newWebSocketBuilder().buildAsync(URI.create("ws://localhost:3300/wpilibws"), new WebSocket.Listener(){
                public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                    assert last;

                    GsonBuilder.

                    return null;
                }
            });
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            LiteralCommandNode<ServerCommandSource> command = CommandManager
                    .literal("frc")
                    .build();

            dispatcher.getRoot().addChild(command);

            command.addChild(StartCommand.getNode());
        });

        LOGGER.info("test");
    }
}

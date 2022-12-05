package dev.blueish.frcemulator.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public final class CommandEvents {
    public static final Event<Start> START = EventFactory.createArrayBacked(Start.class, callbacks -> () -> {
        for (Start callback: callbacks) {
            callback.start();
        }
    });

    @FunctionalInterface
    public interface Start {
        void start();
    }
}

package dev.blueish.frcemulator.ws;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class EntryRegistry {
    private static final HashMap<Type, Entry<?>> REGISTRY = new HashMap<>();

    enum Type {
        Accel,
        AI,
        DIO,
        dPWM,
        DriverStation,
        DutyCycle,
        Encoder,
        Gyro,
        Joystick,
        PWM,
        Relay,
        Solenoid,
    }

    public abstract static class Entry<T> {
        Type type;
        String device;
        T data;

        public Entry<T> deserialize(JsonElement json, T start) {
            JsonObject object = json.getAsJsonObject();

            this.type = Type.valueOf(object.get("type").getAsString());
            this.device = object.get("device").getAsString();
            this.data = this.deserializeData(object.get("data").getAsJsonObject(), start);
        }

        public abstract T deserializeData(JsonObject json, T start);
    }

    static {
        REGISTRY.put(Type.Accel, new Entry<Accelerometer>() {
            @Override
            public Accelerometer deserializeData(JsonObject json, Accelerometer start) {
                if (json.has("<init")) {

                }
            }
        });
    }
}

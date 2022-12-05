package dev.blueish.frcemulator.mixin;

import dev.blueish.frcemulator.FrcEmulator;
import edu.wpi.first.hal.ControlWord;
import edu.wpi.first.hal.DriverStationJNI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = DriverStationJNI.class, remap = false)
public class DriverStationJNIMixin {
    @Redirect(method = "getControlWord", at = @At(value = "INVOKE", target = "Ledu/wpi/first/hal/DriverStationJNI;nativeGetControlWord()I", remap = false), remap = false)
    private static int nativeGetControlWord() {
        return 35;
    }
}

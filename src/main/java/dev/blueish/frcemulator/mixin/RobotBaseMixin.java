package dev.blueish.frcemulator.mixin;

import dev.blueish.frcemulator.FrcEmulator;
import edu.wpi.first.wpilibj.RobotBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = RobotBase.class, remap = false)
public class RobotBaseMixin {
    @Redirect(method = "startRobot", at = @At(value = "INVOKE", target = "Ledu/wpi/first/hal/HAL;report(IIILjava/lang/String;)I", remap = false), remap = false)
    private static int report(int i, int i1, int i2, String s) {
        FrcEmulator.LOGGER.info(s);
        return 0;
    }
}

package com.syuto.base.mixin;


import com.syuto.base.Base;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ExampleMixin { //make sure mixin is added to the mixin config file

    @Inject(method = "<init>", at = @At("RETURN"))
    public void startUp(RunArgs args, CallbackInfo ci) {
        Base.LOGGER.info("ExampleMixin initialized!");
    }
}

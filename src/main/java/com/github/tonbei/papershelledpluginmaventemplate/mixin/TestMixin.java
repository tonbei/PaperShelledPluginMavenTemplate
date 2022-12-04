package com.github.tonbei.papershelledpluginmaventemplate.mixin;

import net.minecraft.world.entity.projectile.AbstractArrow;
import org.bukkit.Bukkit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractArrow.class)
public class TestMixin {

    @Shadow
    private double baseDamage;

    @Inject(at = @At("RETURN"), method = "tick()V"/*, remap = false*/)
    private void onTick(CallbackInfo ci) {
        Bukkit.getLogger().severe("Mixin log");
        ((AbstractArrow) (Object) this).getBaseDamage();
    }

    @Inject(at = @At("HEAD"), method = "getBaseDamage()D"/*, remap = false*/)
    public void getDamage(CallbackInfoReturnable<Double> cir) {
        Bukkit.getLogger().severe("Base Damage: " + baseDamage);
    }
}

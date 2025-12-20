package com.octostudios.reanimal.mixin;

import com.octostudios.reanimal.common.entity.seal.SealEntity;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PolarBear.class)
public abstract class PolarBearMixin {
    @Inject(method = "registerGoals", at = @At("TAIL"))
    private void reanimal$addSealTargetGoal(CallbackInfo ci) {
        PolarBear polarBear = (PolarBear) (Object) this;

        polarBear.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(polarBear, SealEntity.class, true));
    }
}

package me.gjkf.dunemc.mixin;

import me.gjkf.dunemc.Register;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultMixin {
  @Inject(method = "addPlainsFeatures(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
  private static void addPlainsFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
    builder.structureFeature(Register.SIETCH_CONFIGURED);
  }
}
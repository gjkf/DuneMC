package me.gjkf.dunemc.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SpiceMelange extends Item {
  public SpiceMelange(Settings settings) {
    super(settings);
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    user.getStackInHand(hand).decrement(1);
    user.setOnFireFor(1);
    // Gives blindness, the effect is that it seems like the world opened again
    user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20));
    // The spice melange increases the user's lifespan
    user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50));
    return TypedActionResult.success(user.getStackInHand(hand));
  }
}

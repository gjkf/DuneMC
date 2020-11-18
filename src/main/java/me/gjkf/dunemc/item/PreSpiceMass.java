package me.gjkf.dunemc.item;

import me.gjkf.dunemc.Register;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PreSpiceMass extends Item {
  public PreSpiceMass(Settings settings) {
    super(settings);
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    // The spice melange is crafted when the pre spice mass enters contact with water and oxygen
    if (user.isTouchingWater()) {
      user.getStackInHand(hand).decrement(1);
      user.inventory.insertStack(new ItemStack(Register.SPICE, 1));
    }
    return TypedActionResult.success(user.getStackInHand(hand));
  }
}

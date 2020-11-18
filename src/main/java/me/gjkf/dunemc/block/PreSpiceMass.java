package me.gjkf.dunemc.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

public class PreSpiceMass extends Block {

  private static final BooleanProperty LIT = BooleanProperty.of("lit");

  public PreSpiceMass(Settings settings) {
    super(settings);
    setDefaultState(getStateManager().getDefaultState().with(LIT, false));
  }

  @Override
  public void onSteppedOn(World world, BlockPos pos, Entity entity) {
    spawnParticles(world, pos);
    if (!world.getBlockState(pos).get(LIT)) {
      world.setBlockState(pos, world.getBlockState(pos).with(LIT, true));
    }
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(LIT);
  }

  @Override
  public boolean hasRandomTicks(BlockState state) {
    return state.get(LIT);
  }

  @Environment(EnvType.CLIENT)
  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    if (state.get(LIT)) {
      spawnParticles(world, pos);
    }
  }

  private static void spawnParticles(World world, BlockPos pos) {
    double d = 0.5625D;
    Random random = world.random;
    Direction[] var5 = Direction.values();
    int var6 = var5.length;

    for (int var7 = 0; var7 < var6; ++var7) {
      Direction direction = var5[var7];
      BlockPos blockPos = pos.offset(direction);
      if (!world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
        Direction.Axis axis = direction.getAxis();
        double e =
            axis == Direction.Axis.X
                ? 0.5D + 0.5625D * (double) direction.getOffsetX()
                : (double) random.nextFloat();
        double f =
            axis == Direction.Axis.Y
                ? 0.5D + 0.5625D * (double) direction.getOffsetY()
                : (double) random.nextFloat();
        double g =
            axis == Direction.Axis.Z
                ? 0.5D + 0.5625D * (double) direction.getOffsetZ()
                : (double) random.nextFloat();
        world.addParticle(
            new DustParticleEffect(0.29f, 0.17f, 0.03f, 1f),
            (double) pos.getX() + e,
            (double) pos.getY() + f,
            (double) pos.getZ() + g,
            0.0D,
            0.0D,
            0.0D);
      }
    }
  }
}

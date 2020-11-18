package me.gjkf.dunemc;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dunemc implements ModInitializer {

  public static final Logger log = LogManager.getLogger("dunemc");

  public static final ItemGroup ITEM_GROUP =
      FabricItemGroupBuilder.build(
          new Identifier(Register.MOD_ID, "general"), () -> new ItemStack(Register.SPICE));

  @Override
  public void onInitialize() {
    log.info("Beginning registration");
    Register.registerItems();
    Register.registerBlocks();
    log.info("DuneMC registration complete!");
  }
}

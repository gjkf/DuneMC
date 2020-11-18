package me.gjkf.dunemc;

import me.gjkf.dunemc.block.ArrakisSand;
import me.gjkf.dunemc.block.PreSpiceMass;
import me.gjkf.dunemc.item.SandwormTooth;
import me.gjkf.dunemc.item.SpiceMelange;
import me.gjkf.dunemc.item.material.ArmorMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {

  public static final String MOD_ID = "dunemc";

  public static final ArmorMaterial stillsuitMaterial = ArmorMaterials.STILLSUIT;
  public static final ArmorMaterial advancedStillsuitMaterial = ArmorMaterials.ADVANCED_STILLSUIT;

  public static final SpiceMelange SPICE =
      new SpiceMelange(new FabricItemSettings().group(Dunemc.ITEM_GROUP));
  public static final SandwormTooth SANDWORM_TOOTH =
      new SandwormTooth(new FabricItemSettings().group(Dunemc.ITEM_GROUP));
  public static final me.gjkf.dunemc.item.PreSpiceMass PRE_SPICE_MASS_ITEM =
      new me.gjkf.dunemc.item.PreSpiceMass(new FabricItemSettings().group(Dunemc.ITEM_GROUP));

  public static final Item STILLSUIT_HELMET =
      new ArmorItem(
          stillsuitMaterial, EquipmentSlot.HEAD, new Item.Settings().group(Dunemc.ITEM_GROUP));
  public static final Item STILLSUIT_CHESTPLATE =
      new ArmorItem(
          stillsuitMaterial, EquipmentSlot.CHEST, new Item.Settings().group(Dunemc.ITEM_GROUP));
  public static final Item STILLSUIT_LEGGINS =
      new ArmorItem(
          stillsuitMaterial, EquipmentSlot.LEGS, new Item.Settings().group(Dunemc.ITEM_GROUP));
  public static final Item STILLSUIT_BOOTS =
      new ArmorItem(
          stillsuitMaterial, EquipmentSlot.FEET, new Item.Settings().group(Dunemc.ITEM_GROUP));

  public static final Item ADVANCED_STILLSUIT_HELMET =
      new ArmorItem(
          advancedStillsuitMaterial,
          EquipmentSlot.HEAD,
          new Item.Settings().group(Dunemc.ITEM_GROUP));
  public static final Item ADVANCED_STILLSUIT_CHESTPLATE =
      new ArmorItem(
          advancedStillsuitMaterial,
          EquipmentSlot.CHEST,
          new Item.Settings().group(Dunemc.ITEM_GROUP));
  public static final Item ADVANCED_STILLSUIT_LEGGINS =
      new ArmorItem(
          advancedStillsuitMaterial,
          EquipmentSlot.LEGS,
          new Item.Settings().group(Dunemc.ITEM_GROUP));
  public static final Item ADVANCED_STILLSUIT_BOOTS =
      new ArmorItem(
          advancedStillsuitMaterial,
          EquipmentSlot.FEET,
          new Item.Settings().group(Dunemc.ITEM_GROUP));

  public static final PreSpiceMass PRE_SPICE_MASS =
      new PreSpiceMass(Block.Settings.of(Material.STONE).strength(4.0f));
  public static final ArrakisSand ARRAKIS_SAND =
      new ArrakisSand(
          AbstractBlock.Settings.of(Material.AGGREGATE)
              .sounds(BlockSoundGroup.SAND)
              .strength(0.6f));
  public static final Block ARRAKIS_SANDSTONE =
      new Block(
          AbstractBlock.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(1f));

  public static void registerItems() {
    Registry.register(
        Registry.ITEM, new Identifier("dunemc", "stillsuit_helmet"), STILLSUIT_HELMET);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "stillsuit_chestplate"),
        STILLSUIT_CHESTPLATE);
    Registry.register(
        Registry.ITEM, new Identifier(Register.MOD_ID, "stillsuit_leggigs"), STILLSUIT_LEGGINS);
    Registry.register(
        Registry.ITEM, new Identifier(Register.MOD_ID, "stillsuit_boots"), STILLSUIT_BOOTS);

    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "advanced_stillsuit_helmet"),
        ADVANCED_STILLSUIT_HELMET);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "advanecd_stillsuit_chestplate"),
        ADVANCED_STILLSUIT_CHESTPLATE);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "advanced_stillsuit_leggins"),
        ADVANCED_STILLSUIT_LEGGINS);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "advanced_stillsuit_boots"),
        ADVANCED_STILLSUIT_BOOTS);

    Registry.register(Registry.ITEM, new Identifier(Register.MOD_ID, "spice"), SPICE);
    Registry.register(
        Registry.ITEM, new Identifier(Register.MOD_ID, "sandworm_tooth"), SANDWORM_TOOTH);
    Registry.register(
        Registry.ITEM, new Identifier(Register.MOD_ID, "pre_spice_mass_item"), PRE_SPICE_MASS_ITEM);
  }

  public static void registerBlocks() {
    Registry.register(
        Registry.BLOCK, new Identifier(Register.MOD_ID, "arrakis_sand"), ARRAKIS_SAND);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "arrakis_sand"),
        new BlockItem(ARRAKIS_SAND, new Item.Settings().group(Dunemc.ITEM_GROUP)));
    Registry.register(
        Registry.BLOCK, new Identifier(Register.MOD_ID, "arrakis_sandstone"), ARRAKIS_SANDSTONE);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "arrakis_sandstone"),
        new BlockItem(ARRAKIS_SANDSTONE, new Item.Settings().group(Dunemc.ITEM_GROUP)));
    Registry.register(
        Registry.BLOCK, new Identifier(Register.MOD_ID, "pre_spice_mass"), PRE_SPICE_MASS);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "pre_spice_mass"),
        new BlockItem(PRE_SPICE_MASS, new Item.Settings().group(Dunemc.ITEM_GROUP)));
  }
}

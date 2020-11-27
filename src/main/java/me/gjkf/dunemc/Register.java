package me.gjkf.dunemc;

import me.gjkf.dunemc.block.ArrakisSand;
import me.gjkf.dunemc.block.PreSpiceMass;
import me.gjkf.dunemc.item.SandwormTooth;
import me.gjkf.dunemc.item.SpiceMelange;
import me.gjkf.dunemc.item.material.ArmorMaterials;
import me.gjkf.dunemc.world.ArrakisCarver;
import me.gjkf.dunemc.world.feature.SietchFeature;
import me.gjkf.dunemc.world.feature.SietchGenerator;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.structure.rule.RandomBlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class Register {

  public static final String MOD_ID = "dunemc";

  public static final ItemGroup ITEM_GROUP =
      FabricItemGroupBuilder.build(
          new Identifier(Register.MOD_ID, "general"), () -> new ItemStack(Register.SPICE));

  public static final ArmorMaterial stillsuitMaterial = ArmorMaterials.STILLSUIT;
  public static final ArmorMaterial advancedStillsuitMaterial = ArmorMaterials.ADVANCED_STILLSUIT;

  public static final SpiceMelange SPICE =
      new SpiceMelange(new FabricItemSettings().group(ITEM_GROUP));
  public static final SandwormTooth SANDWORM_TOOTH =
      new SandwormTooth(new FabricItemSettings().group(ITEM_GROUP));
  public static final me.gjkf.dunemc.item.PreSpiceMass PRE_SPICE_MASS_ITEM =
      new me.gjkf.dunemc.item.PreSpiceMass(new FabricItemSettings().group(ITEM_GROUP));

  public static final Item STILLSUIT_HELMET =
      new ArmorItem(stillsuitMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ITEM_GROUP));
  public static final Item STILLSUIT_CHESTPLATE =
      new ArmorItem(stillsuitMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ITEM_GROUP));
  public static final Item STILLSUIT_LEGGINS =
      new ArmorItem(stillsuitMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ITEM_GROUP));
  public static final Item STILLSUIT_BOOTS =
      new ArmorItem(stillsuitMaterial, EquipmentSlot.FEET, new Item.Settings().group(ITEM_GROUP));

  public static final Item ADVANCED_STILLSUIT_HELMET =
      new ArmorItem(
          advancedStillsuitMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ITEM_GROUP));
  public static final Item ADVANCED_STILLSUIT_CHESTPLATE =
      new ArmorItem(
          advancedStillsuitMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ITEM_GROUP));
  public static final Item ADVANCED_STILLSUIT_LEGGINS =
      new ArmorItem(
          advancedStillsuitMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ITEM_GROUP));
  public static final Item ADVANCED_STILLSUIT_BOOTS =
      new ArmorItem(
          advancedStillsuitMaterial, EquipmentSlot.FEET, new Item.Settings().group(ITEM_GROUP));

  public static final PreSpiceMass PRE_SPICE_MASS =
      new PreSpiceMass(Block.Settings.of(Material.STONE).strength(4.0f));
  public static final ArrakisSand ARRAKIS_SAND =
      new ArrakisSand(
          Block.Settings.of(Material.AGGREGATE).sounds(BlockSoundGroup.SAND).strength(0.6f));
  public static final Block ARRAKIS_SANDSTONE =
      new Block(Block.Settings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(1f));

  public static final ConfiguredFeature<?, ?> PRE_SPICE_MASS_ORE =
      Feature.ORE
          .configure(
              new OreFeatureConfig(
                  new RandomBlockMatchRuleTest(Register.ARRAKIS_SANDSTONE, 0.5f),
                  Register.PRE_SPICE_MASS.getDefaultState(),
                  5))
          .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(50, 40, 70)))
          .spreadHorizontally()
          .repeat(5);

  public static final StructurePieceType SIETCH_PIECE = SietchGenerator.SietchPiece::new;
  private static final StructureFeature<DefaultFeatureConfig> SIETCH_STRUCTURE =
      new SietchFeature(DefaultFeatureConfig.CODEC);
  public static final ConfiguredStructureFeature<?, ?> SIETCH_CONFIGURED =
      SIETCH_STRUCTURE.configure(DefaultFeatureConfig.DEFAULT);

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
        new BlockItem(ARRAKIS_SAND, new Item.Settings().group(ITEM_GROUP)));
    Registry.register(
        Registry.BLOCK, new Identifier(Register.MOD_ID, "arrakis_sandstone"), ARRAKIS_SANDSTONE);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "arrakis_sandstone"),
        new BlockItem(ARRAKIS_SANDSTONE, new Item.Settings().group(ITEM_GROUP)));
    Registry.register(
        Registry.BLOCK, new Identifier(Register.MOD_ID, "pre_spice_mass"), PRE_SPICE_MASS);
    Registry.register(
        Registry.ITEM,
        new Identifier(Register.MOD_ID, "pre_spice_mass"),
        new BlockItem(PRE_SPICE_MASS, new Item.Settings().group(ITEM_GROUP)));
  }

  public static void registerWorld() {
    // CARVER
    Registry.register(
        Registry.CARVER,
        new Identifier(MOD_ID, "cave"),
        new ArrakisCarver(ProbabilityConfig.CODEC, 256));

    // ORE
    RegistryKey<ConfiguredFeature<?, ?>> pre_spice_mass_ore =
        RegistryKey.of(
            Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(MOD_ID, "pre_spice_mass_ore"));
    Registry.register(
        BuiltinRegistries.CONFIGURED_FEATURE, pre_spice_mass_ore.getValue(), PRE_SPICE_MASS_ORE);
    // TODO: figure out how to properly use JSON and hope it works one day
    BiomeModifications.addFeature(
        BiomeSelectors.includeByKey(
            RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "great_flat"))),
        GenerationStep.Feature.UNDERGROUND_ORES,
        pre_spice_mass_ore);

    // STRUCTURE
    Registry.register(
        Registry.STRUCTURE_PIECE, new Identifier(MOD_ID, "sietch_piece"), SIETCH_PIECE);
    FabricStructureBuilder.create(new Identifier(MOD_ID, "sietch_structure"), SIETCH_STRUCTURE)
        .step(GenerationStep.Feature.SURFACE_STRUCTURES)
        .defaultConfig(32, 8, 12345)
        .adjustsSurface()
        .register();

    RegistryKey<ConfiguredStructureFeature<?, ?>> sietch_configured =
        RegistryKey.of(
            Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
            new Identifier(MOD_ID, "sietch_structure"));
    BuiltinRegistries.add(
        BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE,
        sietch_configured.getValue(),
        SIETCH_CONFIGURED);

  }
}

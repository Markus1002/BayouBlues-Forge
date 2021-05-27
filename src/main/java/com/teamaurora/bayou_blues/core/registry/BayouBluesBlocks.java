package com.teamaurora.bayou_blues.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.*;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchSlabBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchStairsBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.thatch.ThatchVerticalSlabBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.wood.*;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.mojang.datafixers.util.Pair;
import com.teamaurora.bayou_blues.common.block.*;
import com.teamaurora.bayou_blues.common.block.trees.CypressTree;
import com.teamaurora.bayou_blues.core.BayouBlues;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BayouBlues.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BayouBluesBlocks {
    public static final BlockSubRegistryHelper HELPER = BayouBlues.REGISTRY_HELPER.getBlockSubHelper();

    // cypress
    public static final RegistryObject<Block> STRIPPED_CYPRESS_LOG = HELPER.createBlock("stripped_cypress_log", ()->new StrippedLogBlock(Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_CYPRESS_WOOD = HELPER.createBlock("stripped_cypress_wood", ()->new StrippedWoodBlock(Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_LOG = HELPER.createBlock("cypress_log", ()->new AbnormalsLogBlock(STRIPPED_CYPRESS_LOG, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_WOOD = HELPER.createBlock("cypress_wood", ()->new WoodBlock(STRIPPED_CYPRESS_WOOD, Properties.LOG), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_LEAVES = HELPER.createBlock("cypress_leaves", ()->new AbnormalsLeavesBlock(Properties.CYPRESS_LEAVES), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_SAPLING = HELPER.createBlock("cypress_sapling", ()->new AbnormalsSaplingBlock(new CypressTree(), Properties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = HELPER.createBlockNoItem("potted_cypress_sapling", ()->new FlowerPotBlock(CYPRESS_SAPLING.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> CYPRESS_PLANKS = HELPER.createBlock("cypress_planks", ()->new PlanksBlock(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_SLAB = HELPER.createBlock("cypress_slab", ()->new WoodSlabBlock(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_STAIRS = HELPER.createBlock("cypress_stairs", ()->new WoodStairsBlock(CYPRESS_PLANKS.get().getDefaultState(), Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_PRESSURE_PLATE = HELPER.createBlock("cypress_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.PRESSURE_PLATE), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_FENCE = HELPER.createFuelBlock("cypress_fence", ()->new WoodFenceBlock(Properties.PLANKS), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_FENCE_GATE = HELPER.createFuelBlock("cypress_fence_gate", ()->new WoodFenceGateBlock(Properties.PLANKS), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_BUTTON = HELPER.createBlock("cypress_button", ()->new AbnormalsWoodButtonBlock(Properties.BUTTON), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_DOOR = HELPER.createBlock("cypress_door", ()->new WoodDoorBlock(Properties.DOOR), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> CYPRESS_TRAPDOOR = HELPER.createBlock("cypress_trapdoor", ()->new WoodTrapDoorBlock(Properties.DOOR), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> CYPRESS_SIGNS = HELPER.createSignBlock("cypress", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> CYPRESS_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "cypress_bookshelf", ()->new BookshelfBlock(Properties.BOOKSHELF), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> VERTICAL_CYPRESS_PLANKS = HELPER.createCompatBlock("quark", "vertical_cypress_planks", ()->new Block(Properties.PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "cypress_vertical_slab", ()->new VerticalSlabBlock(Properties.PLANKS), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_LADDER = HELPER.createCompatFuelBlock("quark", "cypress_ladder", ()->new AbnormalsLadderBlock(Properties.LADDER), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_LEAF_CARPET = HELPER.createBlock("cypress_leaf_carpet", ()->new LeafCarpetBlock(Properties.CYPRESS_CARPET), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_CYPRESS_POST = HELPER.createCompatFuelBlock("quark", "stripped_cypress_post", () -> new WoodPostBlock(Properties.PLANKS), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_POST = HELPER.createCompatFuelBlock("quark", "cypress_post", () -> new WoodPostBlock(STRIPPED_CYPRESS_POST, Properties.PLANKS), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_HEDGE = HELPER.createCompatFuelBlock("quark", "cypress_hedge", () -> new HedgeBlock(Properties.HEDGE), 300, ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> CYPRESS_CHESTS = HELPER.createCompatChestBlocks("quark", "cypress", MaterialColor.PURPLE_TERRACOTTA);

    public static final RegistryObject<Block> CYPRESS_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "cypress_beehive", ()->new AbnormalsBeehiveBlock(AbstractBlock.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> HANGING_CYPRESS_LEAVES = HELPER.createBlock("hanging_cypress_leaves", ()->new HangingCypressLeavesBlock(Properties.CYPRESS_LEAVES), ItemGroup.DECORATIONS);

    public static final RegistryObject<Block> CYPRESS_KNEE = HELPER.createBlock("cypress_knee", ()->new CypressKneeBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD).notSolid()), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> LARGE_CYPRESS_KNEE = HELPER.createBlock("large_cypress_knee", ()->new DoubleCypressKneeBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD).notSolid()), ItemGroup.DECORATIONS);

    // gooseberries
    public static final RegistryObject<Block> CYPRESS_BRANCH = HELPER.createBlock("cypress_branch", ()->new CypressBranchBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.BAMBOO_SAPLING)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> GOOSEBERRY_SACK = HELPER.createCompatBlock("quark", "gooseberry_sack", ()->new Block(Block.Properties.create(Material.WOOL, MaterialColor.GREEN).hardnessAndResistance(0.5F).sound(SoundType.CLOTH)), ItemGroup.DECORATIONS);

    // lilies
    public static final RegistryObject<Block> BLUE_LILY = HELPER.createBlockNoItem("blue_lily", ()->new LilyFlowerBlock(BayouBluesItems.BLUE_LILY, Properties.LILY));
    public static final RegistryObject<Block> LIGHT_GRAY_LILY = HELPER.createBlockNoItem("light_gray_lily", ()->new LilyFlowerBlock(BayouBluesItems.LIGHT_GRAY_LILY, Properties.LILY));
    public static final RegistryObject<Block> CYAN_LILY = HELPER.createBlockNoItem("cyan_lily", ()->new LilyFlowerBlock(BayouBluesItems.CYAN_LILY, Properties.LILY));
    public static final RegistryObject<Block> LIGHT_BLUE_LILY = HELPER.createBlockNoItem("light_blue_lily", ()->new LilyFlowerBlock(BayouBluesItems.LIGHT_BLUE_LILY, Properties.LILY));
    public static final RegistryObject<Block> MAGENTA_LILY = HELPER.createBlockNoItem("magenta_lily", ()->new LilyFlowerBlock(BayouBluesItems.MAGENTA_LILY, Properties.LILY));
    public static final RegistryObject<Block> PINK_LILY = HELPER.createBlockNoItem("pink_lily", ()->new LilyFlowerBlock(BayouBluesItems.PINK_LILY, Properties.LILY));
    public static final RegistryObject<Block> PURPLE_LILY = HELPER.createBlockNoItem("purple_lily", ()->new LilyFlowerBlock(BayouBluesItems.PURPLE_LILY, Properties.LILY));
    public static final RegistryObject<Block> WHITE_LILY = HELPER.createBlockNoItem("white_lily", ()->new LilyFlowerBlock(BayouBluesItems.WHITE_LILY, Properties.LILY));

    public static final RegistryObject<Block> POTTED_BLUE_LILY = HELPER.createBlockNoItem("potted_blue_lily", ()->new FlowerPotBlock(BLUE_LILY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_LIGHT_GRAY_LILY = HELPER.createBlockNoItem("potted_light_gray_lily", ()->new FlowerPotBlock(LIGHT_GRAY_LILY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_CYAN_LILY = HELPER.createBlockNoItem("potted_cyan_lily", ()->new FlowerPotBlock(CYAN_LILY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_LIGHT_BLUE_LILY = HELPER.createBlockNoItem("potted_light_blue_lily", ()->new FlowerPotBlock(LIGHT_BLUE_LILY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_MAGENTA_LILY = HELPER.createBlockNoItem("potted_magenta_lily", ()->new FlowerPotBlock(MAGENTA_LILY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_PINK_LILY = HELPER.createBlockNoItem("potted_pink_lily", ()->new FlowerPotBlock(PINK_LILY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_PURPLE_LILY = HELPER.createBlockNoItem("potted_purple_lily", ()->new FlowerPotBlock(PURPLE_LILY.get(), Properties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_WHITE_LILY = HELPER.createBlockNoItem("potted_white_lily", ()->new FlowerPotBlock(WHITE_LILY.get(), Properties.FLOWER_POT));

    // algae
    public static final RegistryObject<Block> ALGAE = HELPER.createBlockNoItem("algae", ()->new AlgaeBlock(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance().sound(SoundType.LILY_PADS).notSolid().doesNotBlockMovement()));
    public static final RegistryObject<Block> ALGAE_THATCH = HELPER.createBlock("algae_thatch", ()->new ThatchBlock(Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_SLAB = HELPER.createBlock("algae_thatch_slab", ()->new ThatchSlabBlock(Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_STAIRS = HELPER.createBlock("algae_thatch_stairs", ()->new ThatchStairsBlock(ALGAE_THATCH.get().getDefaultState(), Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "algae_thatch_vertical_slab", ()->new ThatchVerticalSlabBlock(Properties.ALGAE_THATCH), ItemGroup.BUILDING_BLOCKS);

    // other
    public static final RegistryObject<Block> BEARD_MOSS_BLOCK = HELPER.createFuelBlock("beard_moss_block", ()->new BeardMossBlockBlock(AbstractBlock.Properties.create(Material.PLANTS).hardnessAndResistance(0.1F).sound(SoundType.PLANT).notSolid()), 800, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BEARD_MOSS = HELPER.createFuelBlock("beard_moss", ()->new BeardMossBlock(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance().sound(SoundType.PLANT).notSolid().doesNotBlockMovement().tickRandomly()), 800, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> GIANT_FERN = HELPER.createBlock("giant_fern", ()->new DoublePlantBlock(AbstractBlock.Properties.from(Blocks.TALL_GRASS)), ItemGroup.DECORATIONS);

    public static class Properties {
        public static final AbstractBlock.Properties ALGAE_THATCH = AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.LIME).hardnessAndResistance(0.5F).sound(SoundType.PLANT).notSolid().harvestTool(ToolType.HOE);
        public static final AbstractBlock.Properties HEDGE = AbstractBlock.Properties.from(Blocks.OAK_FENCE);

        public static final AbstractBlock.Properties CYPRESS_LEAVES = AbstractBlock.Properties.create(Material.LEAVES, MaterialColor.GREEN).harvestTool(ToolType.HOE).notSolid().hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).setAllowsSpawn(BayouBluesBlocks.Properties::allowsSpawnOnLeaves).setSuffocates(BayouBluesBlocks.Properties::isntSolid).setBlocksVision(BayouBluesBlocks.Properties::isntSolid);;
        public static final AbstractBlock.Properties CYPRESS_CARPET = AbstractBlock.Properties.create(Material.CARPET, MaterialColor.GREEN).hardnessAndResistance(0.0F).sound(SoundType.PLANT).harvestTool(ToolType.HOE).notSolid();

        public static final AbstractBlock.Properties PLANKS = AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties DOOR = AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).notSolid().hardnessAndResistance(3.0F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties BUTTON = AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties PRESSURE_PLATE = AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties LADDER = AbstractBlock.Properties.create(Material.MISCELLANEOUS).notSolid().harvestTool(ToolType.AXE).hardnessAndResistance(0.4F).sound(SoundType.LADDER);
        public static final AbstractBlock.Properties BOOKSHELF = AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(1.5F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties LOG = AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
        public static final AbstractBlock.Properties SAPLING = AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT);

        public static final AbstractBlock.Properties FLOWER_POT = AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F).notSolid();

        public static final AbstractBlock.Properties LILY = AbstractBlock.Properties.from(Blocks.LILY_PAD);

        public static boolean allowsSpawnOnLeaves(BlockState state, IBlockReader access, BlockPos pos, EntityType<?> entity) {
            return entity == EntityType.OCELOT || entity == EntityType.PARROT;
        }

        public static boolean alwaysAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
            return true;
        }

        public static boolean needsPostProcessing(BlockState state, IBlockReader reader, BlockPos pos) {
            return true;
        }

        public static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
            return false;
        }
    }
}

package com.teamaurora.bayou_blues.core.other;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.bayou_blues.core.registry.BayouBluesBlocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;

import java.util.Arrays;

public class BayouBluesRendering {
    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.CYPRESS_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.POTTED_CYPRESS_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.CYPRESS_LEAF_CARPET.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.CYPRESS_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.HANGING_CYPRESS_LEAVES.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.CYPRESS_KNEE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.LARGE_CYPRESS_KNEE.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.CYPRESS_BRANCH.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.ALGAE.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.BEARD_MOSS_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.BEARD_MOSS.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.BLUE_LILY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.LIGHT_GRAY_LILY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.CYAN_LILY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.LIGHT_BLUE_LILY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.MAGENTA_LILY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.PINK_LILY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.PURPLE_LILY.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.WHITE_LILY.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(BayouBluesBlocks.GIANT_FERN.get(), RenderType.getCutout());
    }

    public static void registerBlockColors() {
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(), Arrays.asList(BayouBluesBlocks.CYPRESS_LEAVES, BayouBluesBlocks.HANGING_CYPRESS_LEAVES, BayouBluesBlocks.CYPRESS_LEAF_CARPET));
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? 2129968 : 7455580, Arrays.asList(BayouBluesBlocks.BLUE_LILY, BayouBluesBlocks.LIGHT_GRAY_LILY, BayouBluesBlocks.CYAN_LILY, BayouBluesBlocks.LIGHT_BLUE_LILY, BayouBluesBlocks.MAGENTA_LILY, BayouBluesBlocks.PINK_LILY, BayouBluesBlocks.PURPLE_LILY, BayouBluesBlocks.WHITE_LILY));
        DataUtil.registerBlockColor(blockColors, (x, world, pos, u) -> world != null && pos != null ? BiomeColors.getGrassColor(world, x.get(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER ? pos.down() : pos) : -1, Arrays.asList(BayouBluesBlocks.GIANT_FERN));

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> FoliageColors.getDefault(), Arrays.asList(BayouBluesBlocks.CYPRESS_LEAVES, BayouBluesBlocks.HANGING_CYPRESS_LEAVES, BayouBluesBlocks.CYPRESS_LEAF_CARPET));
        DataUtil.registerBlockItemColor(itemColors, (color, items) -> GrassColors.get(0.5D, 1.0D), Arrays.asList(BayouBluesBlocks.GIANT_FERN));
    }
}

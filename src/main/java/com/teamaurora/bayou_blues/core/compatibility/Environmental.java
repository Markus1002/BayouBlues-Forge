package com.teamaurora.bayou_blues.core.compatibility;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ObjectHolder;

public class Environmental {
    @ObjectHolder("environmental:giant_tall_grass")
    public static final Block GIANT_TALL_GRASS = null;

    @ObjectHolder("environmental:mud")
    public static final Block MUD = null;

    @ObjectHolder("environmental:cattails")
    public static final Feature<NoFeatureConfig> CATTAILS = null;

    public static boolean installed() {
        return ModList.get() != null && ModList.get().isLoaded("environmental");
    }
}

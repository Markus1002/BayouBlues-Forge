package com.teamaurora.bayou_blues.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.bayou_blues.core.other.BayouBluesCompat;
import com.teamaurora.bayou_blues.core.other.BayouBluesEvents;
import com.teamaurora.bayou_blues.core.registry.BayouBluesBiomes;
import com.teamaurora.bayou_blues.core.registry.BayouBluesFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BayouBlues.MODID)
public class BayouBlues
{
    public static final String MODID = "bayou_blues";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public BayouBlues() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(eventBus);

        BayouBluesFeatures.FEATURES.register(eventBus);
        BayouBluesFeatures.TREE_DECORATORS.register(eventBus);

        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(new BayouBluesEvents());

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BayouBluesConfig.COMMON_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BayouBluesFeatures.Configured.registerConfiguredFeatures();
            BayouBluesCompat.registerFlammables();
            BayouBluesCompat.registerCompostables();

            BayouBluesBiomes.addBiomeTypes();
            BayouBluesBiomes.registerBiomesToDictionary();
            BayouBluesBiomes.addHillBiome();
        });
    }
}
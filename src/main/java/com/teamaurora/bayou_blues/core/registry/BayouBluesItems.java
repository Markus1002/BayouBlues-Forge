package com.teamaurora.bayou_blues.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.bayou_blues.common.item.*;
import com.teamaurora.bayou_blues.core.BayouBlues;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BayouBlues.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BayouBluesItems {
    public static final ItemSubRegistryHelper HELPER = BayouBlues.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> CYPRESS_BOAT = HELPER.createBoatItem("cypress", BayouBluesBlocks.CYPRESS_PLANKS);

    public static final RegistryObject<Item> GOOSEBERRIES = HELPER.createItem("gooseberries", ()->new Item(new Item.Properties().food(Foods.GOOSEBERRIES).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> GOOSEBERRY_JUICE = HELPER.createItem("gooseberry_juice", ()->new DrinkItem(new Item.Properties().food(Foods.GOOSEBERRY_JUICE).maxStackSize(16).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> GOOSEBERRY_PIE = HELPER.createItem("gooseberry_pie", ()->new Item(new Item.Properties().food(Foods.GOOSEBERRY_PIE).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> HONEY_GLAZED_GOOSEBERRIES = HELPER.createItem("honey_glazed_gooseberries", ()->new Item(new Item.Properties().food(Foods.HONEY_GLAZED_GOOSEBERRIES).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> GOOSEBERRY_JAM = HELPER.createItem("gooseberry_jam", ()->new JamItem(new Item.Properties().containerItem(Items.GLASS_BOTTLE).food(Foods.GOOSEBERRY_JAM).maxStackSize(16).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> GOOSEBERRY_JAM_COOKIE = HELPER.createItem("gooseberry_jam_cookie", ()->new Item(new Item.Properties().food(Foods.GOOSEBERRY_JAM_COOKIE).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> ALGAE = HELPER.createItem("algae", ()->new AlgaeItem(BayouBluesBlocks.ALGAE.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> BEARD_MOSS = HELPER.createItem("beard_moss", ()->new TreeMossItem(BayouBluesBlocks.BEARD_MOSS.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> BEARD_MOSS_BLOCK = HELPER.createItem("beard_moss_block", ()->new TreeMossBlockItem(BayouBluesBlocks.BEARD_MOSS_BLOCK.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

    public static final RegistryObject<Item> BLUE_LILY = HELPER.createItem("blue_lily", ()->new LilyItem(BayouBluesBlocks.BLUE_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_GRAY_LILY = HELPER.createItem("light_gray_lily", ()->new LilyItem(BayouBluesBlocks.LIGHT_GRAY_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> CYAN_LILY = HELPER.createItem("cyan_lily", ()->new LilyItem(BayouBluesBlocks.CYAN_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_BLUE_LILY = HELPER.createItem("light_blue_lily", ()->new LilyItem(BayouBluesBlocks.LIGHT_BLUE_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> MAGENTA_LILY = HELPER.createItem("magenta_lily", ()->new LilyItem(BayouBluesBlocks.MAGENTA_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> PINK_LILY = HELPER.createItem("pink_lily", ()->new LilyItem(BayouBluesBlocks.PINK_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> PURPLE_LILY = HELPER.createItem("purple_lily", ()->new LilyItem(BayouBluesBlocks.PURPLE_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> WHITE_LILY = HELPER.createItem("white_lily", ()->new LilyItem(BayouBluesBlocks.WHITE_LILY.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

    public static class Foods {
        public static final Food GOOSEBERRIES = (new Food.Builder()).hunger(2).saturation(0.2F).build();
        public static final Food GOOSEBERRY_JUICE = (new Food.Builder()).hunger(1).saturation(0.1F).build();
        public static final Food GOOSEBERRY_PIE = (new Food.Builder()).hunger(6).saturation(0.5F).build();

        public static final Food HONEY_GLAZED_GOOSEBERRIES = (new Food.Builder()).hunger(7).saturation(0.3F).build();
        public static final Food GOOSEBERRY_JAM = (new Food.Builder()).hunger(2).saturation(0.25F).build();
        public static final Food GOOSEBERRY_JAM_COOKIE = (new Food.Builder().hunger(2).saturation(0.3F)).build();
    }
}

package com.teamaurora.bayou_blues.core.other;

import com.minecraftabnormals.abnormals_core.core.util.TradeUtil;
import com.teamaurora.bayou_blues.common.block.CypressKneeBlock;
import com.teamaurora.bayou_blues.common.block.DoubleCypressKneeBlock;
import com.teamaurora.bayou_blues.common.block.LilyFlowerBlock;
import com.teamaurora.bayou_blues.core.BayouBlues;
import com.teamaurora.bayou_blues.core.BayouBluesConfig;
import com.teamaurora.bayou_blues.core.registry.BayouBluesBlocks;
import com.teamaurora.bayou_blues.core.registry.BayouBluesItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BayouBlues.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BayouBluesEvents {

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        if (event.getSource() == DamageSource.FALL) {
            BlockPos pos = event.getEntity().getPosition().down();
            IWorldReader world = event.getEntity().getEntityWorld();
            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();

            if (block instanceof CypressKneeBlock || block instanceof DoubleCypressKneeBlock) {
                event.getEntity().attackEntityFrom(DamageSource.GENERIC, event.getAmount() * 2);
            }
        }
    }

    private boolean checkAdjacentForSolid(World world, BlockPos pos) {
        for (int i = 0; i < 4; i++) {
            Direction dir = Direction.byHorizontalIndex(i);
            BlockPos poffset = pos.offset(dir);

            if (world.getFluidState(poffset).getFluid() != Fluids.WATER) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public void onBonemealUse(BonemealEvent event) {
        BlockState state = event.getBlock();
        BlockPos pos = event.getPos();
        World world = event.getWorld();

        //world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState(), 3);

        if (state.getBlock() == Blocks.LILY_PAD && BayouBluesConfig.COMMON.lilyBonemealBehavior.get() == 1) {
            if (!ModList.get().isLoaded("environmental") || world.getRandom().nextBoolean() || checkAdjacentForSolid(world, pos.down())) {
                Block lily = LilyFlowerBlock.getRandomLily(world.getRandom());

                if (!world.isRemote) {
                    world.setBlockState(pos, lily.getDefaultState(), 3);
                    event.setResult(Event.Result.ALLOW);
                }
            }
        }
        if (BayouBluesConfig.COMMON.lilyBonemealBehavior.get() == 2) {
            Block stateBlock = state.getBlock();
            if (stateBlock instanceof LilyFlowerBlock) {
                Block.spawnAsEntity(world, pos, stateBlock.getItem(world, pos, state));
                event.setResult(Event.Result.ALLOW);
            }
        }
        if (state.getBlock() == Blocks.LARGE_FERN) {
            if (state.get(DoublePlantBlock.HALF) == DoubleBlockHalf.LOWER) {
                ((DoublePlantBlock) BayouBluesBlocks.GIANT_FERN.get()).placeAt(world, pos, 3);
            } else {
                ((DoublePlantBlock) BayouBluesBlocks.GIANT_FERN.get()).placeAt(world, pos.down(), 3);
            }
            event.setResult(Event.Result.ALLOW);
        }
    }

    @SubscribeEvent
    public static void onWandererTradesEvent(WandererTradesEvent event) {
        TradeUtil.addWandererTrades(event,
                new TradeUtil.AbnormalsTrade(1, BayouBluesItems.ALGAE.get(), 2, 6, 1),

                new TradeUtil.AbnormalsTrade(5, BayouBluesBlocks.CYPRESS_SAPLING.get().asItem(), 1, 8, 1)
        );

        if (BayouBluesConfig.COMMON.doLiliesSpawn.get() || BayouBluesConfig.COMMON.lilyBonemealBehavior.get() != 0) {
            // lilies are enabled
            TradeUtil.addWandererTrades(event,
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.BLUE_LILY.get(), 1, 7, 1),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.CYAN_LILY.get(), 1, 7, 1),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.LIGHT_BLUE_LILY.get(), 1, 7, 1),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.LIGHT_GRAY_LILY.get(), 1, 7, 1),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.WHITE_LILY.get(), 1, 7, 1),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.PINK_LILY.get(), 1, 7, 1),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.PURPLE_LILY.get(), 1, 7, 1),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.MAGENTA_LILY.get(), 1, 7, 1)
            );
        }
    }

    @SubscribeEvent
    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if (event.getType().equals(VillagerProfession.FARMER)) {
            TradeUtil.addVillagerTrades(event, TradeUtil.APPRENTICE,
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.GOOSEBERRY_PIE.get(), 4, 12, 5),
                    new TradeUtil.AbnormalsTrade(1, BayouBluesItems.GOOSEBERRY_JAM_COOKIE.get(), 18, 12, 5),
                    new TradeUtil.AbnormalsTrade(2, BayouBluesItems.GOOSEBERRIES.get(), 16, 12, 10)
            );
        }
    }

    // might reconsider this later
    /*@SubscribeEvent
    public static void onLivingEntityUseItem(LivingEntityUseItemEvent event) {
        if (event.getItem().getItem() instanceof FishingRodItem) {
            if (event.getEntity() instanceof PlayerEntity) {
                PlayerEntity playerIn = (PlayerEntity) event.getEntity();
                World worldIn = playerIn.getEntityWorld();
                Hand handIn = playerIn.swingingHand;
                ItemStack itemstack = event.getItem();
                if (playerIn.fishingBobber == null) {
                    boolean flag = false;
                    for (BlockPos pos : BlockPos.getAllInBoxMutable(playerIn.getPosition().add(-10, -10, -10), playerIn.getPosition().add(10, 10, 10))) {
                        if (worldIn.getBlockState(pos).getBlock() == BayouBluesBlocks.ALGAE.get()) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_FISHING_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (playerIn.getRNG().nextFloat() * 0.4F + 0.8F));
                        if (!worldIn.isRemote) {
                            int k = EnchantmentHelper.getFishingSpeedBonus(itemstack);
                            int j = EnchantmentHelper.getFishingLuckBonus(itemstack) + 2;
                            worldIn.addEntity(new FishingBobberEntity(playerIn, worldIn, j, k));
                        }

                        playerIn.addStat(Stats.ITEM_USED.get(itemstack.getItem()));

                        event.setResult(Event.Result.ALLOW);
                    }
                }
            }
        }
    }*/
}

package com.teamaurora.bayou_blues.common.item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class JamItem extends DrinkItem {
    public JamItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAction getUseAction(ItemStack itemStack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }
}
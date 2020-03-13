package com.kuxiao.othermod.Items;

import com.kuxiao.othermod.Util.BaseItem;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestItem extends BaseItem {

    public TestItem(String name) {
        super(name);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        System.out.println("onBlockDestroyed");
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player) {
        System.out.println("onBlockStartBreak");
        return false;
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        return true;
    }
}

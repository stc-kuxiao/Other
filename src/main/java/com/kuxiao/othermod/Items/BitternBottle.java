package com.kuxiao.othermod.Items;

import com.kuxiao.othermod.base.BaseItem;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BitternBottle extends BaseItem {

    public BitternBottle(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isRemote) {
            ItemStack itemstack = playerIn.getHeldItem(handIn);
            RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY );
            BlockState blockState = worldIn.getBlockState(new BlockPos(raytraceresult.getHitVec()));
            System.out.println(blockState.toString());

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

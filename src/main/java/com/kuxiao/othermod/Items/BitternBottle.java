package com.kuxiao.othermod.Items;

import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.Init.ModFluids;
import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BitternBottle extends Item {

    public BitternBottle(String name) {
        super(new Properties().maxStackSize(16).group(Utils.itemGroup));
        this.setRegistryName(name);
        ModItems.MODITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isRemote) {
            ItemStack itemStack = playerIn.getHeldItem(handIn);
            RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY );
            BlockState blockState = worldIn.getBlockState(new BlockPos(raytraceresult.getHitVec()));
            if(blockState.getFluidState() != Fluids.EMPTY.getDefaultState()) {
                if(blockState.getFluidState() == ModFluids.BEAN_MILK.getDefaultState().with(FlowingFluid.FALLING,false)){
                    worldIn.setBlockState(new BlockPos(raytraceresult.getHitVec()), ModBlocks.tofuBlockTender.getDefaultState());
                    if(!playerIn.abilities.isCreativeMode) {
                        itemStack.shrink(1);
                    }
                    playerIn.addItemStackToInventory(Items.GLASS_BOTTLE.getDefaultInstance());
                }
            }

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

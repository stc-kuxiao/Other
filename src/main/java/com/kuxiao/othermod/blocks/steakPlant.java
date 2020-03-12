package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.BasePlantNoLight;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class steakPlant extends BasePlantNoLight {

    public steakPlant(String name) {
        super(name);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!worldIn.isRemote && !player.isCreative()){
            if(this.isMaxAge(state)){
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(Items.COOKED_BEEF, worldIn.rand.nextInt(1)+1)));
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(ModItems.steakSeed, worldIn.rand.nextInt(2))));
            }else {
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(ModItems.steakSeed, 1)));
            }
        }
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            if(this.isMaxAge(state)) {
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(Items.COOKED_BEEF, worldIn.rand.nextInt(1)+1)));
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(ModItems.steakSeed, worldIn.rand.nextInt(2))));
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }
}

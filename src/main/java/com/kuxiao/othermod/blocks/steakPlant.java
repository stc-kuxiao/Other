package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.BasePlantNoLight;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
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
        if(!worldIn.isRemote && !player.abilities.isCreativeMode){
            if(this.isMaxAge(state)){
                Utils.dropItem(worldIn,pos,Items.COOKED_BEEF,1,2);
                Utils.dropItem(worldIn,pos,ModItems.steakSeed,0,2);
            }else {
                Utils.dropItem(worldIn,pos,ModItems.steakSeed,1,1);
            }
        }
        super.onBlockHarvested(worldIn,pos,state,player);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            if(this.isMaxAge(state)) {
                Utils.dropItem(worldIn,pos,Items.COOKED_BEEF,1,2);
                Utils.dropItem(worldIn,pos,ModItems.steakSeed,0,2);
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }
}

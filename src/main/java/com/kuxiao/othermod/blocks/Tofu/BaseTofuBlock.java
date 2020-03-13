package com.kuxiao.othermod.blocks.Tofu;

import com.kuxiao.othermod.Util.BaseBlock;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class BaseTofuBlock extends BaseBlock {
    public BaseTofuBlock(String name, int harvestLevel, float hardness) {
        super(name, Material.CLAY, harvestLevel, ToolType.SHOVEL, hardness, SoundType.STONE);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!Utils.isCreativeMode(player) && !worldIn.isRemote){
            Utils.dropItem(worldIn,pos, this.asItem(),1);
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
    }
}

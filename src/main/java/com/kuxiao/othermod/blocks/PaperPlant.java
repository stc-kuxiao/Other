package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Util.BasePlantAge3;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class PaperPlant extends BasePlantAge3 {

    public PaperPlant(String name) {
        super(name);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){

        }
        return false;
    }
}

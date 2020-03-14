package com.kuxiao.othermod.blocks.Tofu;

import com.kuxiao.othermod.Init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class StoneTofu extends BaseTofuHard {

    public StoneTofu(String name, int harvestLevel, float hardness) {
        super(name, harvestLevel, hardness);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);
        BlockState up = worldIn.getBlockState(pos.add(0,1,0));
        BlockState down = worldIn.getBlockState(pos.add(0,-1,0));
        boolean b1 = (up.getMaterial() == Material.ROCK || up.getMaterial() == Material.IRON);
        boolean b2 = (down.getMaterial() == Material.ROCK || down.getMaterial() == Material.IRON);
        if(b1 && b2){
            int odds = 256;
            if(random.nextInt(odds)==0){
                worldIn.setBlockState(pos, ModBlocks.tofuBlockIron.getDefaultState());
            }
        }
    }
}

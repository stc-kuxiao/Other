package com.kuxiao.othermod.blocks.Tofu;

import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class NormalTofu extends BaseTofuBlock {

    public NormalTofu(String name, int harvestLevel, float hardness) {
        super(name, harvestLevel, hardness);
    }

    private boolean hasRock = false;
    private boolean isTransform = false;


    /**
     * 每个tick都会调用
     * @param stateIn
     * @param worldIn
     * @param pos
     * @param rand
     */
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn,worldIn,pos,rand);
        BlockState up = worldIn.getBlockState(pos.add(0,1,0));
        BlockState down = worldIn.getBlockState(pos.add(0,-1,0));
        boolean upB = (up.getMaterial() == Material.ROCK || up.getMaterial() == Material.IRON);
        boolean downB = (down.getMaterial() == Material.ROCK || down.getMaterial() == Material.IRON);
        hasRock = upB && downB;
        if(isTransform){
            System.out.println(this.getDefaultState().toString());
            worldIn.setBlockState(pos, ModBlocks.tofuBlockStone.getDefaultState());
            //worldIn.notifyBlockUpdate(pos, stateIn, ModBlocks.tofuBlockStone.getDefaultState(),3);
            System.out.println(this.getDefaultState().toString());

        }
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        if(hasRock){
            /*转变概率*/
            int odds = 64;
            int z = Utils.RANDOM.nextInt(odds);
            System.out.println(z);
            if(z==0){
                isTransform = true;
            }
        }

        return super.ticksRandomly(state);
    }
}

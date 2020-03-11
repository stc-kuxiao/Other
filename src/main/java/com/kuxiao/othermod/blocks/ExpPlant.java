package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.BasePlant;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class ExpPlant extends BasePlant {

    //public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

    public ExpPlant(String name) {
        super(name,10);
    }

    /**
     * 破坏方块掉落物品，只因为json太难写(((
     */
//    @Override
//    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
//        if(!worldIn.isRemote){
//            worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(ModItems.expSeed, 1)));
//        }
//    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            if(this.isMaxAge(state)){
                int rd = worldIn.rand.nextInt(20);
                rd = rd>15?1:0;
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.expSeed, rd)));
                this.getExpDrop(state,worldIn,pos,0,0);
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return this.isMaxAge(state)?new Random().nextInt(50)+fortune*5:0;
    }
}

package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.BasePlant;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CornPlant extends BasePlant {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

    public CornPlant(String name) {
        super(name, 0);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote)
        {
            if(this.isMaxAge(state))
            {
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.cornSeed, worldIn.rand.nextInt(3) + 1)));
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }

}

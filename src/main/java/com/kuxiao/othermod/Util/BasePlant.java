package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BasePlant extends CropsBlock {
    protected BasePlant(String name, int light) {
        super(Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP).lightValue(light));
        this.setRegistryName(name);
        ModBlocks.MODBLOCK.add(this);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return state.getBlock() instanceof FarmlandBlock;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    protected IItemProvider getSeedsItem()
    {
        return this;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
    {
        return new ItemStack(this.getSeedsItem());
    }

//    @Override
//    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        if(!world.isRemote)
//        {
//            if(this.isMaxAge(state))
//            {
//                world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(<ItemPlants>, world.rand.nextInt(3) + 1)));
//                world.setBlockState(pos, this.withAge(0));
//                return true;
//            }
//        }
//        return false;
//    }
}

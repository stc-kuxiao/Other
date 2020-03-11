package com.kuxiao.othermod.Util;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class BasePlantAge3 extends BasePlantNoLight {

    private static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

    private Item fruit;

    public BasePlantAge3(String name,Item item) {
        super(name);
        setFruit(item);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    @Override
    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
    }

    @Override
    public boolean isMaxAge(BlockState state) {
        return state.get(this.getAgeProperty()) >= this.getMaxAge();
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.nextInt(worldIn.rand, 2, 5);
    }

    protected void setFruit(Item item){
        fruit = item;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            if(this.isMaxAge(state)){
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(fruit, worldIn.rand.nextInt(3) + 1)));
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }
}

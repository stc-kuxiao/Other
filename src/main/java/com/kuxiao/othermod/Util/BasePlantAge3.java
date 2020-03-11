package com.kuxiao.othermod.Util;

import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BasePlantAge3 extends BasePlantNoLight {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

    public BasePlantAge3(String name) {
        super(name);
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
}

package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Util.BaseBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class ExpOre extends BaseBlock {

    public static final int MAX_EXPORE_XP = 20;
    public static final int MIN_EXPORE_XP = 5;

    public ExpOre(String name) {
        super(name, Material.ROCK, 1, ToolType.PICKAXE, 5f, SoundType.STONE);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? MathHelper.nextInt(new Random(), MIN_EXPORE_XP, MAX_EXPORE_XP) : 0;
    }


}

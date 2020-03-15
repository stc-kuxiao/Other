package com.kuxiao.othermod.blocks.Tree;

import com.kuxiao.othermod.Init.ModTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * @author kuxiao
 * new树苗方块用到了这个类
 */
public class GrapefruitTree extends Tree {
    @Nullable
    @Override
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return (AbstractTreeFeature<NoFeatureConfig>)ModTree.grapefruitTree;
    }
}

package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.blocks.Tree.GrapefruitTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.List;

public class ModTree {
    public static final List<Feature> MODTREES = new ArrayList<Feature>();

    public static final Feature<NoFeatureConfig> grapefruitTree  = new GrapefruitTreeFeature("grapefruit_tree",NoFeatureConfig::deserialize, true, false);




}

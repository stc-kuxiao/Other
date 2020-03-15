package com.kuxiao.othermod.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenTree  {

    /**
     * 生成树
     * @param tree 树类 in ModTree
     * @param count 数量 普通为1
     * @param extraChanceIn 额外机会 0.1F
     * @param extraCountIn 二外数量 1
     * @param biomes 生成群系...   Biome.Category.XXX
     */
    public static void setupTreeGeneration(Feature<NoFeatureConfig> tree, int count, float extraChanceIn, int extraCountIn, Biome.Category... biomes){
        for(Biome biome: ForgeRegistries.BIOMES){
            for(Biome.Category category: biomes){
                if(biome.getCategory() == category){
                    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                            Biome.createDecoratedFeature(
                                    tree,
                                    NoFeatureConfig.NO_FEATURE_CONFIG,
                                    Placement.COUNT_EXTRA_HEIGHTMAP,
                                    new AtSurfaceWithExtraConfig(count,extraChanceIn,extraCountIn)
                            )
                    );
                }
            }

        }
    }

}

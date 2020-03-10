package com.kuxiao.othermod.world.gen;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenOre{
    /* CountRangeConfig参数介绍:
     * size是矿物生成大小
     * 200:石头被替换，2：没有，4：64*64区域内有4个
     * count是世界选择他进行生成的概率
     * 最高生成在maximum
     * bottonOffset是设置高度偏移，也就是最低生成位置
     * -----------------------------------
     * count size详解：
     * 在size=2下，几乎不生成
     * 4:1下就会生成一些
     * 4：10下回生成的更多，但是看起来都是零散的一小撮一小撮的
     * -----------------------------------
     * 常用参数:size:count
     * 绿宝石:4:1
     * 煤炭:15:40
     * 铁:10:20
     * 钻石:7:10
     */

    public static void setupOreGenerationOverWorld(Block block, int size, int count, int bottomOffset, int maximum){
        for(Biome biome:ForgeRegistries.BIOMES){
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Biome.createDecoratedFeature(Feature.ORE,new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, block.getDefaultState(),size), Placement.COUNT_RANGE,new CountRangeConfig(count, bottomOffset, 0, maximum)));
        }
    }

    public static void setupOreGenerationNether(Block block, int size, int count, int bottomOffset, int maximum){
        for(Biome biome:ForgeRegistries.BIOMES){
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Biome.createDecoratedFeature(Feature.ORE,new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, block.getDefaultState(),size), Placement.COUNT_RANGE,new CountRangeConfig(count, bottomOffset, 0, maximum)));
        }
    }



}

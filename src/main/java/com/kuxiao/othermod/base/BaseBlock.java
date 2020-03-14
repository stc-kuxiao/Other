package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BaseBlock extends Block {
    /**
     * @param name 注册名
     * @param material 材质
     * @param harvestLevel 挖掘等级
     * @param toolType 采掘工具
     * @param hardness 硬度 & 爆炸抗性
     * @param soundType 音效
     */
    public BaseBlock(String name, Material material, int harvestLevel, ToolType toolType, float hardness, SoundType soundType) {
        super(Properties.create(material)
                .harvestLevel(harvestLevel)
                .harvestTool(toolType)
                .hardnessAndResistance(hardness)
                .sound(soundType)
        );
        this.setRegistryName(name);
        ModBlocks.MODBLOCK.add(this);
    }

}

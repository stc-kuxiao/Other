package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BaseBlock extends Block {
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

package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModBlocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BaseGlass extends GlassBlock {

    protected BaseGlass(String name, Material material, int harvestLevel, ToolType toolType, float hardness, SoundType soundType) {
        super(Properties.create(material)
                .harvestLevel(harvestLevel)
                .harvestTool(toolType)
                .hardnessAndResistance(hardness)
                .sound(soundType)
                .variableOpacity()/*透明变量*/
        );
        this.setRegistryName(name);
        ModBlocks.MODBLOCK.add(this);
    }
}

package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.blocks.*;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> MODBLOCK = new ArrayList<Block>();

    public static ObsidianBlock obsidianBlock = new ObsidianBlock("obsidian_block");
    public static CountBlock countBlock = new CountBlock("count_block");
    public static FilterBlock filterBlock = new FilterBlock("filter_block");
    public static ExpOre expOre = new ExpOre("exp_ore");
    public static ExpPlant expPlant = new ExpPlant("exp_plant");

}

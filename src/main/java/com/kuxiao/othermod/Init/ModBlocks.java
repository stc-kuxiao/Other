package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.blocks.*;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> MODBLOCK = new ArrayList<Block>();

    public static Block obsidianBlock = new ObsidianBlock("obsidian_block");
    public static Block countBlock = new CountBlock("count_block");
    public static Block filterBlock = new FilterBlock("filter_block");
    public static Block expOre = new ExpOre("exp_ore");
    public static Block expPlant = new ExpPlant("exp_plant");
    public static Block cornPlant = new CornPlant("corn_plant");
    public static Block paperPlant = new PaperPlant("paper_plant");
    public static Block steakPlant = new steakPlant("steak_plant");

}

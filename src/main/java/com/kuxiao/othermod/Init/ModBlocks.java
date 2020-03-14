package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.base.BaseFluidBlock;
import com.kuxiao.othermod.blocks.*;
import com.kuxiao.othermod.blocks.Tofu.NormalTofu;
import com.kuxiao.othermod.blocks.Tofu.StoneTofu;
import com.kuxiao.othermod.blocks.Tofu.TofuBlockTender;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> MODBLOCK = new ArrayList<Block>();
    public static final List<Block> MODBLOCK_ONLY = new ArrayList<Block>();


    public static Block obsidianBlock = new ObsidianBlock("obsidian_block");
    public static Block countBlock = new CountBlock("count_block");
    public static Block filterBlock = new FilterBlock("filter_block");
    public static Block expOre = new ExpOre("exp_ore");
    public static Block expPlant = new ExpPlant("exp_plant");
    public static Block cornPlant = new CornPlant("corn_plant");
    public static Block paperPlant = new PaperPlant("paper_plant");
    public static Block steakPlant = new steakPlant("steak_plant");
    public static Block sievesBlock = new sievesBlock("sieves_block");
    public static Block tofuBlockTender = new TofuBlockTender("tofu_block_tender");
    public static Block tofuBlockNormal = new NormalTofu("tofu_block_normal",0,1.0f);
    public static Block tofuBlockStone = new StoneTofu("tofu_block_stone",1,1.5f);

    public static Block oilBlock = new BaseFluidBlock("oil",()-> ModFluids.OIL);
    public static Block beanMilkBlock = new BaseFluidBlock("bean_milk",()->ModFluids.BEAN_MILK);


}

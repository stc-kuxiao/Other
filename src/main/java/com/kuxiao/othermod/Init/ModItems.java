package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.Items.Corn;
import com.kuxiao.othermod.Items.ObsidianIngot;
import com.kuxiao.othermod.Items.raw_corn;
import com.kuxiao.othermod.Util.BaseSeed;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> MODITEMS = new ArrayList<Item>();

    public static ObsidianIngot obsidianIngot = new ObsidianIngot("obsidian_ingot");
    public static Item expSeed = new BaseSeed("exp_seed",ModBlocks.expPlant);
    public static Item cornSeed = new BaseSeed("corn_seed",ModBlocks.cornPlant);
    public static Item corn = new Corn("corn",4,1.5f);
    public static Item rawCorn = new raw_corn("raw_corn",1,0.6f);

}

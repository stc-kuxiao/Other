package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.Items.ObsidianIngot;
import com.kuxiao.othermod.Util.BaseSeed;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> MODITEMS = new ArrayList<Item>();

    public static ObsidianIngot obsidianIngot = new ObsidianIngot("obsidian_ingot");
    public static Item expSeed = new BaseSeed("exp_seed",ModBlocks.expPlant);
    public static Item cornSeed = new BaseSeed("corn_seed",ModBlocks.cornPlant);

}

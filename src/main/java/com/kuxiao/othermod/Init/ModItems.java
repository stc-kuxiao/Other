package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.Items.BitternBottle;
import com.kuxiao.othermod.base.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> MODITEMS = new ArrayList<Item>();

    /*tools*/

    public static Item obsidianAxe = BaseTools.createTools("obsidian_axe", BaseTools.TOOL.Axe,ToolMaterialList.obsidian,-1,2.0f);
    public static Item obsidianHoe = BaseTools.createTools("obsidian_hoe", BaseTools.TOOL.Hoe,ToolMaterialList.obsidian,-2,2.0f);
    public static Item obsidianPickAxe = BaseTools.createTools("obsidian_pickaxe", BaseTools.TOOL.PickAxe,ToolMaterialList.obsidian,-2,2.0f);
    public static Item obsidianShovel = BaseTools.createTools("obsidian_shovel", BaseTools.TOOL.Shovel,ToolMaterialList.obsidian,-3,2.0f);
    public static Item obsidianSword = BaseTools.createTools("obsidian_sword", BaseTools.TOOL.Sword,ToolMaterialList.obsidian,0,2.0f);
    public static BaseArmor obsidianArmor = new BaseArmor("obsidian",ArmorMaterialList.obsidian);

    /*fluid*/

    public static Item oilBucket = new BaseBucket("oil_bucket",()-> ModFluids.OIL);
    public static Item beanMilkBucket = new BaseBucket("bean_milk_bucket",()-> ModFluids.BEAN_MILK);

    /*seeds*/

    public static Item expSeed = new BaseSeed("exp_seed",ModBlocks.expPlant);
    public static Item cornSeed = new BaseSeed("corn_seed",ModBlocks.cornPlant);
    public static Item paperSeed = new BaseSeed("paper_seed",ModBlocks.paperPlant);
    public static Item steakSeed = new BaseSeed("steak_seed",ModBlocks.steakPlant);

    /*normal*/

    public static Item obsidianIngot = new BaseItem("obsidian_ingot");
    public static Item tofuStone = new BaseItem("tofu_stone");
    public static Item tofuIron = new BaseItem("tofu_iron");
    public static Item salt = new BaseItem("salt");
    public static Item bitternBottle = new BitternBottle("bittern_bottle");

    /*foods*/

    public static Item grapefruit = new BaseFoodItem("grapefruit",3,1.5f);
    public static Item corn = new BaseFoodItem("corn",4,1.5f);
    public static Item rawCorn = new BaseFoodItem("raw_corn",1,0.6f);
    public static Item tofuNormal = new BaseFoodItem("tofu_normal",2,1.0f);
    public static Item tofuTender = new BaseFoodItem("tofu_tender",2,1.2f);



}

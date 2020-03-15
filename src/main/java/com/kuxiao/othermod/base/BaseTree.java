package com.kuxiao.othermod.base;


import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.Othermod;
import com.kuxiao.othermod.blocks.Tree.saplingBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.Tree;

import java.util.Arrays;

public class BaseTree {

    private Block[] blocks = new Block[5];

    public BaseTree(String name, Tree tree){
        blocks[0] = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Othermod.MODID, name+"_planks");
        blocks[1] = new saplingBlock(tree, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0f).sound(SoundType.PLANT)).setRegistryName(Othermod.MODID,name+"_sapling");
        blocks[2] =  new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Othermod.MODID,name+"_log");
        blocks[3] = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Othermod.MODID,name+"_wood");
        blocks[4] = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)).setRegistryName(Othermod.MODID,name+"_leaves");
        ModBlocks.MODBLOCK.addAll(Arrays.asList(blocks));
    }

    /**
     * @return 木板
     */
    public Block getPlanks(){return blocks[0];}
    /**
     * @return 树苗
     */
    public Block getSapling(){return blocks[1];}
    /**
     * @return 原木
     */
    public Block getLogs(){return blocks[2];}
    /**
     * @return 去皮原木
     */
    public Block getWood(){return blocks[3];}
    /**
     * @return 树叶
     */
    public Block getLeaves(){return blocks[4];}

}

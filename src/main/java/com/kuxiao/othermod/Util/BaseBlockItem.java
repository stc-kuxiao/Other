package com.kuxiao.othermod.Util;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BaseBlockItem extends BlockItem {

    public BaseBlockItem(Block blockIn) {
        super(blockIn,new Properties().group(Utils.itemGroup));
        this.setRegistryName(blockIn.getRegistryName());
    }
}

package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Util.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BaseBlockItem extends BlockItem {

    public BaseBlockItem(Block blockIn) {
        super(blockIn,new Properties().group(Utils.itemGroup));
        this.setRegistryName(blockIn.getRegistryName());
    }
}

package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;

public class BaseSeed extends BlockNamedItem {

    public BaseSeed(String name,Block blockIn) {
        super(blockIn,new Properties().maxStackSize(64));
        this.setRegistryName(name);
        ModItems.MODITEMS.add(this);
    }
}

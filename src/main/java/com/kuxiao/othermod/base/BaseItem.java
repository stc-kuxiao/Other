package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.item.Item;

public class BaseItem extends Item {
    public BaseItem(String name) {
        super(new Properties().maxStackSize(64).group(Utils.itemGroup));
        this.setRegistryName(name);
        ModItems.MODITEMS.add(this);
    }
}

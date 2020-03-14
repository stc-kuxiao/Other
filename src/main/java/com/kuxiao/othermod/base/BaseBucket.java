package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class BaseBucket extends BucketItem {

    public BaseBucket(String name,Supplier<? extends Fluid> supplier) {
        super(supplier, new Item.Properties().group(Utils.itemGroup).maxStackSize(1));
        this.setRegistryName(name);
        ModItems.MODITEMS.add(this);
    }
}

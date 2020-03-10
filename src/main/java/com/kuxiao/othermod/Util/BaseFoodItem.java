package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModItems;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class BaseFoodItem extends Item {

    public BaseFoodItem(String name, int hunger, float saturation)
    {
        super(new Properties().group(Utils.itemGroup).food(new Food.Builder().saturation(saturation).hunger(hunger).build()));
        this.setRegistryName(name);
        ModItems.MODITEMS.add(this);
    }

}

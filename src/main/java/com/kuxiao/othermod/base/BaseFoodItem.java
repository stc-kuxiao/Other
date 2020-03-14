package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.Utils;
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

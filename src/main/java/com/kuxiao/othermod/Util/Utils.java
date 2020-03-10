package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Utils {


    public static ItemGroup itemGroup = new ItemGroup("othermod"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.obsidianIngot);
        }

    };
}

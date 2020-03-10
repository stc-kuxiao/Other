package com.kuxiao.othermod.Init;

import net.minecraft.block.ComposterBlock;

public class ComposterItems {

    public static void register(){
        ComposterBlock.CHANCES.put(ModItems.corn,0.85f);
        ComposterBlock.CHANCES.put(ModItems.rawCorn,0.65f);
    }

}

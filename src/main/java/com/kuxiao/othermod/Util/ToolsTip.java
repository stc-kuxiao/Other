package com.kuxiao.othermod.Util;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;

public class ToolsTip extends TextComponent {

    String key;

    public ToolsTip(String key){
        this.key = "othermod.tip."+key;
    }



    @Override
    public String getUnformattedComponentText() {

        return key;
    }



    @Override
    public ITextComponent shallowCopy() {
        return this;
    }
}

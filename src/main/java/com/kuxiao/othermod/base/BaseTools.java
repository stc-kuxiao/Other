package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Init.ToolMaterialList;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.item.*;

public class BaseTools{

    public static Item createTools(String name, TOOL tool, ToolMaterialList material,int addAtk,float atkSpeed) {
        Item item;
        Item.Properties properties = new Item.Properties().maxStackSize(64).group(Utils.itemGroup);
        switch (tool){
            case Axe:item = new AxeItem(material,addAtk,atkSpeed,properties);break;
            case Hoe:item = new HoeItem(material,atkSpeed,properties);break;
            case Sword:item = new SwordItem(material,addAtk,atkSpeed,properties);break;
            case Shovel:item = new ShovelItem(material,addAtk,atkSpeed,properties);break;
            case PickAxe:item = new PickaxeItem(material,addAtk,atkSpeed,properties);break;
            default:return null;
        }
        item.setRegistryName(name);
        ModItems.MODITEMS.add(item);
        return item;
    }


    public enum TOOL{
        /**
         * axe:斧子
         * pickaxe：镐子
         * hoe：锄头
         * shovel：铲子
         * sword：剑
         */
        Axe,
        PickAxe,
        Hoe,
        Shovel,
        Sword
    }

}

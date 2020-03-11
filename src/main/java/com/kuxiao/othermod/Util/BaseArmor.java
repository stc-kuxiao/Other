package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;

import java.util.Arrays;

public class BaseArmor {
    private static final Item.Properties PROPERTIES =  new Item.Properties().group(Utils.itemGroup);
    private Item[] items;

    public BaseArmor(String name, IArmorMaterial materialIn){
        items = new Item[4];
        items[0] = new ArmorItem(materialIn, EquipmentSlotType.HEAD,PROPERTIES).setRegistryName(name+"_helmet");
        items[1] = new ArmorItem(materialIn, EquipmentSlotType.CHEST,PROPERTIES).setRegistryName(name+"_chestplate");
        items[2] = new ArmorItem(materialIn, EquipmentSlotType.LEGS,PROPERTIES).setRegistryName(name+"_leggings");
        items[3] = new ArmorItem(materialIn, EquipmentSlotType.FEET,PROPERTIES).setRegistryName(name+"_boots");
        ModItems.MODITEMS.addAll(Arrays.asList(items).subList(0, 4));
    }

    public Item get(EquipmentSlotType i){
        if(items == null) {return null;}
        switch (i){
            case HEAD:return items[0];
            case CHEST:return items[1];
            case LEGS:return items[2];
            case FEET:return items[3];
            default:return null;
        }
    }


}

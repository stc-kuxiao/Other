package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.Othermod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial {
    /**
     * name:材质注册名
     * durability:耐久 * MAX_DAMAGE_ARRAY[Index]
     * damageReductionAmounts:护甲值{鞋 裤 胸甲 头}(钻石套为{3,6,8,3})
     * enchantability：附魔幸运
     * repairItem：修复材料
     * equipSound：穿着声音
     * toughness：韧性(钻石套为2)
     */
    obsidian("obsidian",400,new int[]{8,10,9,7},25,ModItems.obsidianIngot,"entity.ender_dragon.growl",0.0f);

    public static final int[] MAX_DAMAGE_ARRAY = new int[]{13,15,16,11};
    int durability,enchantability;
    int[] damageReductionAmounts;
    float toughness;
    Item repairItem;
    String equipSound;

    ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness){
        this.durability = durability;
        this.damageReductionAmounts = damageReductionAmounts;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.equipSound = equipSound;
        this.toughness = toughness;
    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getSlotIndex()]*this.durability;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmounts[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairItem);
    }

    @Override
    public String getName() {
        return Othermod.MODID+":"+this.name();
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}

package com.kuxiao.othermod.Util;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DropItem {
    public static void dropItem(World worldIn, BlockPos pos, Item drop,int dropMin,int dropMax){
        dropMax = Math.max(dropMax, 0);
        dropMin = Math.max(dropMin, 0);
        if(dropMin>dropMax){
            int t = dropMin;
            dropMin = dropMax;
            dropMax = t;
        }
        dropMax -= dropMin;
        if(dropMax==0){
            worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(drop, dropMin)));
        }else{
            worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(drop, worldIn.rand.nextInt(dropMax)+dropMin)));
        }

    }

    public static void dropItem(World worldIn, BlockPos pos, Item drop,int dropMin,int dropMax,boolean upOneBlock){
        float y = 0.5f;
        if(upOneBlock){
            y+=1f;
        }
        dropMax = Math.max(dropMax, 0);
        dropMin = Math.max(dropMin, 0);
        if(dropMin>dropMax){
            int t = dropMin;
            dropMin = dropMax;
            dropMax = t;
        }
        dropMax -= dropMin;
        if(dropMax==0){
            worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+y, pos.getZ()+0.5f, new ItemStack(drop, dropMin)));
        }else{
            worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+y, pos.getZ()+0.5f, new ItemStack(drop, worldIn.rand.nextInt(dropMax)+dropMin)));
        }
    }

    public static void dropItem(World worldIn, BlockPos pos, Item drop,int count){
        worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, new ItemStack(drop, count)));
    }

    public static void dropItem(World worldIn, BlockPos pos, Item drop,int count,boolean upOneBlock){
        float y = 0.5f;
        if(upOneBlock){
            y+=1f;
        }
        worldIn.addEntity(new ItemEntity(worldIn, pos.getX()+0.5f, pos.getY()+y, pos.getZ()+0.5f, new ItemStack(drop, count)));
    }


}

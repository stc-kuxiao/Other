package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Utils {


    public static ItemGroup itemGroup = new ItemGroup("othermod"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.obsidianIngot);
        }

    };

    public static boolean isCreativeMode(PlayerEntity player){
        return player.abilities.isCreativeMode;
    }

    public static void dropItem(World worldIn, BlockPos pos, Item drop, int dropMin, int dropMax){
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

    /**
     * 处理实体权重块
     * from ToFuMod-1.7.10
     * 暂时不会用到
     */
    public static void handleEntityWeightingBlock(World world, Entity entity, Block block){
        int i = MathHelper.floor(entity.getBoundingBox().minX + 0.001D);
        int j = MathHelper.floor(entity.getBoundingBox().minY + 0.001D);
        int k = MathHelper.floor(entity.getBoundingBox().minZ + 0.001D);
        int l = MathHelper.floor(entity.getBoundingBox().maxX - 0.001D);
        int i1 = MathHelper.floor(entity.getBoundingBox().maxY - 0.001D);
        int j1 = MathHelper.floor(entity.getBoundingBox().maxZ - 0.001D);
        if (entity.world.chunkExists(i, j)){
            for (int k1 = i; k1 <= l; ++k1){
                for (int l1 = j; l1 <= i1; ++l1){
                    for (int i2 = k; i2 <= j1; ++i2){
                        int bx = k1;
                        int by = l1 - 1;
                        int bz = i2;
                        BlockPos pos = new BlockPos(bx,by,bz);
                        if (world.getBlockState(pos) == block.getDefaultState()){
                            Utils.dropItem(world,pos,block.asItem(),4,true);
                        }
                    }
                }
            }
        }
    }




}

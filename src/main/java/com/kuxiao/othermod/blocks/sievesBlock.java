package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.BaseGlass;
import com.kuxiao.othermod.Util.DropItem;
import com.kuxiao.othermod.tilesentities.ModTileEntitiesType;
import com.kuxiao.othermod.tilesentities.SievesBlockTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class sievesBlock extends BaseGlass {

    public sievesBlock(String name) {
        super(name, Material.WOOD, 0, ToolType.AXE, 2.0f, SoundType.WOOD);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntitiesType.sievesBlockTileEntityType.create();
    }

    private int maxRand = 255;
    private int expSeedRand = 0;
    private int steakSeedRand = 10;
    private int paperSeedRand = 50;
    private int cornSeedRand = 100;

    public void setRand(int expSeedRand,int steakSeedRand,int paperSeedRand,int cornSeedRand){
        if(maxRand > expSeedRand && maxRand > steakSeedRand && maxRand > paperSeedRand && maxRand > cornSeedRand){
            this.expSeedRand = expSeedRand;
            this.steakSeedRand = steakSeedRand;
            this.paperSeedRand = paperSeedRand;
            this.cornSeedRand = cornSeedRand;
        }
    }

    public boolean setMaxRand(int maxRand){
        if(maxRand > expSeedRand && maxRand > steakSeedRand && maxRand > paperSeedRand && maxRand > cornSeedRand) {
            this.maxRand = maxRand;
            return true;
        }
        return false;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            ItemStack itemStack = player.getHeldItem(handIn);
            if(itemStack.getItem() == Items.DIRT){
                getTE(worldIn,pos).increase();

                /*不是创造模式*/
                if(!player.abilities.isCreativeMode) {
                    /*手中物品-1*/
                    itemStack.shrink(1);
                }
                int rd;
                rd = worldIn.rand.nextInt(maxRand);
                if(rd>=0 && rd <= expSeedRand){DropItem.dropItem(worldIn,pos, ModItems.expSeed,1,true);}
                rd = worldIn.rand.nextInt(maxRand);
                if(rd>=0 && rd <= steakSeedRand){DropItem.dropItem(worldIn,pos, ModItems.steakSeed,1,true);}
                rd = worldIn.rand.nextInt(maxRand);
                if(rd>=0 && rd <= paperSeedRand){DropItem.dropItem(worldIn,pos, ModItems.paperSeed,1,true);}
                rd = worldIn.rand.nextInt(maxRand);
                if(rd>=0 && rd <= cornSeedRand){DropItem.dropItem(worldIn,pos, ModItems.cornSeed,1,true);}

                return true;
            }else if(itemStack.getItem() == ModItems.obsidianIngot){
                TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.othermod.sieves",getTE(worldIn,pos).getCounter());
                translationTextComponent.getStyle().setColor(TextFormatting.BLUE);
                player.sendStatusMessage(translationTextComponent,false);
            }
        }
        return false;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!worldIn.isRemote && !player.abilities.isCreativeMode){
            DropItem.dropItem(worldIn,pos, ModBlocks.sievesBlock.asItem(),1);
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }



    private SievesBlockTileEntity getTE(World world, BlockPos pos){
        return (SievesBlockTileEntity)world.getTileEntity(pos);
    }
}

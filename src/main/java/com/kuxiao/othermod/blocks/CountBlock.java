package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.base.BaseBlock;
import com.kuxiao.othermod.tilesentities.CounterBlockTileEntity;
import com.kuxiao.othermod.Init.ModTileEntitiesType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class CountBlock extends BaseBlock {

    public CountBlock(String name) {
        super(name,Material.ROCK,1,ToolType.PICKAXE,3f,SoundType.STONE);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntitiesType.counterBlockTileEntityType.create();
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            if(hit.getFace()!=Direction.UP && hit.getFace()!=Direction.DOWN){
                int counter;
                if(hit.getHitVec().y-hit.getPos().getY()>0.6f){
                    counter = getTE(worldIn,pos).increase();
                }else {
                    counter = getTE(worldIn,pos).decrease();
                }
                TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.othermod.counter",counter);
                translationTextComponent.getStyle().setColor(TextFormatting.BLUE);
                player.sendStatusMessage(translationTextComponent,false);
            }
        }
        return true;
    }

    private CounterBlockTileEntity getTE(World world,BlockPos pos){
        return (CounterBlockTileEntity)world.getTileEntity(pos);
    }
}

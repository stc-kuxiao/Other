package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Util.BaseBlock;
import com.kuxiao.othermod.tilesentities.FilterBlockTileEntity;
import com.kuxiao.othermod.tilesentities.ModTileEntitiesType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class FilterBlock extends BaseBlock {
    public FilterBlock(String name) {
        super(name, Material.ROCK, 3, ToolType.PICKAXE, 4f, SoundType.STONE);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntitiesType.filterBlockTileEntityType.create();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(placer != null){
            worldIn.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos,placer)), 2);
        }
    }

    private static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
        Vec3d vec = entity.getPositionVec();
        return Direction.getFacingFromVector(
                (float) (vec.x - clickedBlock.getX()),
                (float) (vec.y - clickedBlock.getY()),
                (float) (vec.z - clickedBlock.getZ())
        );
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote) {
            Item sitem;
            sitem = player.getHeldItemMainhand().isEmpty()?getTE(worldIn,pos).getItem():getTE(worldIn,pos).changeItem(player.getHeldItemMainhand().getItem());
            TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.othermod.sitem",sitem.getName());
            translationTextComponent.getStyle().setColor(TextFormatting.BLUE);
            player.sendStatusMessage(translationTextComponent,false);
        }
        return true;
    }

    private FilterBlockTileEntity getTE(World world, BlockPos pos){
        return (FilterBlockTileEntity)world.getTileEntity(pos);
    }

}

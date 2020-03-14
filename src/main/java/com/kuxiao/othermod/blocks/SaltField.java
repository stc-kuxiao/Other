package com.kuxiao.othermod.blocks;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Util.Utils;
import com.kuxiao.othermod.base.BaseGlass;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class SaltField extends BaseGlass {

    /**
     * AGE_0:空状态
     * AGE_1:含水
     * AGE_2:含盐
     * AGE_3:含卤水
     */
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;

    public SaltField(String name) {
        super(name, Material.WOOD, 0, ToolType.AXE, 2.0f, SoundType.WOOD);
        this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), 0));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(this.getAgeProperty());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
    }

    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.getAgeProperty(), age);
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    public boolean isMaxAge(BlockState state) {
        return state.get(this.getAgeProperty()) >= this.getMaxAge();
    }

    public boolean isAgeWith(BlockState state,int age){
        return state.get(this.getAgeProperty()) == age;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(isAgeWith(state,0)){
            if(player.getHeldItem(handIn).getItem() == Items.WATER_BUCKET){
                if(!worldIn.isRemote){
                    if(!player.isCreative()){
                    player.getHeldItem(handIn).shrink(1);
                    player.addItemStackToInventory(Items.BUCKET.getDefaultInstance());
                    }
                worldIn.setBlockState(pos, this.withAge(1));
                }
                return true;
            }
        }else if(isAgeWith(state,2)){
            if(player.getHeldItem(handIn).getItem() == Items.GLASS_BOTTLE){
                if(!worldIn.isRemote){
                    if(!player.isCreative()){
                    player.getHeldItem(handIn).shrink(1);
                    }
                    Utils.dropItem(worldIn,pos, ModItems.salt,1);
                    Utils.dropItem(worldIn,pos, ModItems.bitternBottle,1);
                    worldIn.setBlockState(pos, this.withAge(0));
                }
                return true;
            }
            if(!worldIn.isRemote){
                Utils.dropItem(worldIn,pos, ModItems.salt,1);
                worldIn.setBlockState(pos, this.withAge(3));
            }
            return true;
        }else if(isAgeWith(state,3)){
            if(player.getHeldItem(handIn).getItem() == Items.GLASS_BOTTLE){
                if(!worldIn.isRemote){
                    if(!player.isCreative()){
                        player.getHeldItem(handIn).shrink(1);
                    }
                    Utils.dropItem(worldIn,pos, ModItems.bitternBottle,1);
                    worldIn.setBlockState(pos, this.withAge(0));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);
        int rand = 16;
        if(((SaltField)state.getBlock()).isAgeWith(state,1)){
            if(worldIn.canBlockSeeSky(pos) && !worldIn.isRaining()){
                if(random.nextInt(rand)==0){
                    worldIn.setBlockState(pos,this.withAge(2));
                }
            }
        }
    }
}


package com.kuxiao.othermod.blocks.Tree;

import com.kuxiao.othermod.Init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class grapefruitLeavesBlock extends LeavesBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;


    public IntegerProperty getAgeProperty() { return AGE; }
    public BlockState withAge(int age) {return this.getDefaultState().with(this.getAgeProperty(), age); }
    public int getMaxAge() { return 3; }
    public boolean isMaxAge(BlockState state) { return state.get(this.getAgeProperty()) >= this.getMaxAge(); }
    public boolean getAgeWithState(BlockState state, int age){ return state.get(this.getAgeProperty()) == age; }
    public int getAgeWithState(BlockState state){ return state.get(this.getAgeProperty()); }
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(this.getAgeProperty());
    }

    public grapefruitLeavesBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(getAgeProperty(),0));
    }


    public boolean leaveTree = false;
    public boolean canGather = false;

    @Override
    public boolean ticksRandomly(BlockState state) {
        leaveTree = super.ticksRandomly(state);
        return true;
    }


    @Override
    public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if(leaveTree){
            super.randomTick(state, worldIn, pos, random);
        }else{
            if(!getAgeWithState(state,3) && !state.get(PERSISTENT)){
                canGather = false;
                if(random.nextInt(64)==0){
                    worldIn.setBlockState(pos,this.withAge(getAgeWithState(state)+1).with(DISTANCE,state.get(DISTANCE)));
                }
            }else{
                canGather = true;
            }
        }
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(isMaxAge(state)){
            if(!worldIn.isRemote){
                worldIn.setBlockState(pos,this.withAge(0).with(DISTANCE,state.get(DISTANCE)));
                for(int i = 0; i < worldIn.rand.nextInt(3); i++) {
                    player.addItemStackToInventory(ModItems.grapefruit.getDefaultInstance());
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        //tooltip.add(new ToolsTip("grapefruit_leaves_1").setStyle(new Style().setColor(TextFormatting.YELLOW)));
        //tooltip.add(new ToolsTip("grapefruit_leaves_2").setStyle(new Style().setColor(TextFormatting.YELLOW)));
    }
}

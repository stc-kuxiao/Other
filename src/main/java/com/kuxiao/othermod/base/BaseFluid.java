package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Init.ModFluids;
import com.kuxiao.othermod.Othermod;
import com.kuxiao.othermod.fluids.OilFluid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class BaseFluid extends FlowingFluid {

    /*不要忘记改下面的Flowing和Source继承的类哦*/

    private int color = 0x00000000;
    private int light = 0;
    private int viscosity = 1000;
    private int density = 1000;

    protected Block getBlock(){
        return null;
    }

    @Override
    public Fluid getStillFluid() {
        return null;
    }

    @Override
    public Item getFilledBucket() {
        return null;
    }

    @Override
    public Fluid getFlowingFluid() {
        return null;
    }

    @Override
    public IFluidState getFlowingFluidState(int level, boolean falling) {
        return super.getFlowingFluidState(level, falling);
    }

    @Override
    public boolean isEquivalentTo(Fluid fluidIn) {
        //return fluidIn == FluidReg.OIL || fluidIn == FluidReg.FLOWING_OIL;
        return super.isEquivalentTo(fluidIn);
    }

    public static class Flowing extends OilFluid {
        public Flowing() {
        }
        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, IFluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
        public boolean isSource(IFluidState state) {
            return false;
        }

        @Override
        public int getLevel(IFluidState state) {
            return state.get(OilFluid.LEVEL_1_8);
        }
    }
    public static class Source extends OilFluid {
        public Source() {
        }
        @Override
        public boolean isSource(IFluidState state) {
            return true;
        }

        @Override
        public int getLevel(IFluidState state) {
            return 8;
        }
    }

    @Override
    protected FluidAttributes createAttributes() {

        return FluidAttributes.builder(new ResourceLocation(Othermod.MODID,"block/oil_still"),new ResourceLocation(Othermod.MODID,"block/oil_flow"))
                .translationKey("block."+Othermod.MODID+".oil")
                .color(color)
                .luminosity(light)
                .viscosity(viscosity)
                .density(density)
                .build(this);
    }


/*==============================================================================*/
/*                                 需要更改部分结束                             */
/*==============================================================================*/

    @Override
    protected boolean canSourcesMultiply() {
        return false;
    }

    @Override
    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {

    }

    @Override
    protected int getSlopeFindDistance(IWorldReader worldIn) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
        return 1;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    protected boolean func_215665_a(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(ModFluids.Tags.OIL);
    }

    @Override
    public int getTickRate(IWorldReader world) {
        return 10;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }



    @Override
    protected BlockState getBlockState(IFluidState state) {
        return getBlock().getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    @Override
    public boolean isSource(IFluidState state) {
        return false;
    }

    @Override
    public int getLevel(IFluidState state) {
        return state.get(LEVEL_1_8);
    }






}

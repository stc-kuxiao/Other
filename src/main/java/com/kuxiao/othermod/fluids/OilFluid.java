package com.kuxiao.othermod.fluids;

import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.Init.ModFluids;
import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.Othermod;
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

public class OilFluid extends FlowingFluid {
    private int color = 0xFF282828;
    private int light = 0;
    private int viscosity = 2000;
    private int density = 2000;

    protected Block getBlock(){
        return ModBlocks.oilBlock;
    }

    @Override
    public Fluid getStillFluid() {
        return ModFluids.OIL;
    }

    @Override
    public Item getFilledBucket() {
        return ModItems.oilBucket;
    }

    @Override
    public Fluid getFlowingFluid() {
        return ModFluids.FLOWING_OIL;
    }

    @Override
    public boolean isEquivalentTo(Fluid fluidIn) {
        return fluidIn == ModFluids.OIL || fluidIn == ModFluids.FLOWING_OIL;
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

    @Override
    protected boolean func_215665_a(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(ModFluids.Tags.OIL);
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
        return 2;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public int getTickRate(IWorldReader world) {
        return 40;
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

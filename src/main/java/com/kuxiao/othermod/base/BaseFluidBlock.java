package com.kuxiao.othermod.base;

import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.Othermod;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;

import java.util.function.Supplier;

public class BaseFluidBlock extends FlowingFluidBlock {

    public BaseFluidBlock(String name,Supplier<? extends FlowingFluid> supplier) {
        super(supplier, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops());
        this.setRegistryName(Othermod.MODID,name);
        ModBlocks.MODBLOCK_ONLY.add(this);
    }
}

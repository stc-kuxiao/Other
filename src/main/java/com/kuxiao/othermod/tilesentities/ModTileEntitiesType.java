package com.kuxiao.othermod.tilesentities;

import com.kuxiao.othermod.Init.ModBlocks;
import net.minecraft.tileentity.TileEntityType;

public class ModTileEntitiesType {
    public static TileEntityType<?> counterBlockTileEntityType = TileEntityType.Builder.create(CounterBlockTileEntity::new,ModBlocks.countBlock)
            .build(null).setRegistryName(ModBlocks.countBlock.getRegistryName());
    public static TileEntityType<?> filterBlockTileEntityType = TileEntityType.Builder.create(FilterBlockTileEntity::new,ModBlocks.filterBlock)
            .build(null).setRegistryName(ModBlocks.filterBlock.getRegistryName());
}

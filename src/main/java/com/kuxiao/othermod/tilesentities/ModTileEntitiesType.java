package com.kuxiao.othermod.tilesentities;

import com.kuxiao.othermod.Init.ModBlocks;
import net.minecraft.tileentity.TileEntityType;

public class ModTileEntitiesType {
    /*不要忘记去注册！！！*/
    public static TileEntityType<?> counterBlockTileEntityType = TileEntityType.Builder.create(CounterBlockTileEntity::new,ModBlocks.countBlock)
            .build(null).setRegistryName(ModBlocks.countBlock.getRegistryName());
    public static TileEntityType<?> filterBlockTileEntityType = TileEntityType.Builder.create(FilterBlockTileEntity::new,ModBlocks.filterBlock)
            .build(null).setRegistryName(ModBlocks.filterBlock.getRegistryName());
    public static TileEntityType<?> sievesBlockTileEntityType = TileEntityType.Builder.create(SievesBlockTileEntity::new,ModBlocks.sievesBlock)
            .build(null).setRegistryName(ModBlocks.sievesBlock.getRegistryName());

}

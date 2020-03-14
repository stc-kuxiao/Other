package com.kuxiao.othermod.Util;

import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.tilesentities.ModTileEntitiesType;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegisterHandler {


    @SubscribeEvent
    public static void onBlocksRegistry(RegistryEvent.Register<Block> event) {
        for(Block block:ModBlocks.MODBLOCK){
            event.getRegistry().register(block);
        }
        for(Block block:ModBlocks.MODBLOCK_ONLY){
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
        for(Item item:ModItems.MODITEMS){
            event.getRegistry().register(item);
        }
        for(Block block:ModBlocks.MODBLOCK){
            event.getRegistry().register(new BlockItem(block,
                    new Item.Properties().group(Utils.itemGroup))
                    .setRegistryName(Objects.requireNonNull(block.getRegistryName()))
            );
        }
    }


    @SubscribeEvent
    public static void onTileEntitiesRegistry(RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().register(ModTileEntitiesType.counterBlockTileEntityType);
        event.getRegistry().register(ModTileEntitiesType.filterBlockTileEntityType);
        event.getRegistry().register(ModTileEntitiesType.sievesBlockTileEntityType);
    }

}

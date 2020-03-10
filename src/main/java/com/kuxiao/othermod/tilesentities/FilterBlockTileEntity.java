package com.kuxiao.othermod.tilesentities;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FilterBlockTileEntity extends TileEntity {

    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

    public FilterBlockTileEntity() {
        super(ModTileEntitiesType.filterBlockTileEntityType);
    }

    private static Item wlitem = Items.DIAMOND;

    private IItemHandler createHandler() {
        ItemStackHandler handler = new ItemStackHandler() {
            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (stack.getItem() != wlitem) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() == wlitem;
            }
        };
        handler.setSize(1);
        return handler;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void read(CompoundNBT compound) {
        handler.ifPresent(h->{
            CompoundNBT filterCompound = compound.getCompound("item");
            CompoundNBT filtCompound = compound.getCompound("wlitem");
            ((INBTSerializable<CompoundNBT>)h).deserializeNBT(filterCompound);
            ((INBTSerializable<CompoundNBT>)h).deserializeNBT(filtCompound);
        });
        super.read(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        handler.ifPresent(h->{
            CompoundNBT filterCompound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            CompoundNBT filtesCompound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            compound.put("item",filterCompound);
            compound.put("wlitem",filtesCompound);
        });
        return super.write(compound);
    }

    public Item chengeItem(Item citem){
        wlitem = citem;
        markDirty();
        return wlitem;
    }

    public Item getItem(){
        return wlitem;
    }

}

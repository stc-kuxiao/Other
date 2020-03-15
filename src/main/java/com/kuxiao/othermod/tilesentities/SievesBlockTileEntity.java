package com.kuxiao.othermod.tilesentities;

import com.kuxiao.othermod.Init.ModTileEntitiesType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class SievesBlockTileEntity extends TileEntity {

    private int counter=0;

    public int increase(){
        counter++;
        markDirty();
        return counter;
    }

    public int decrease(){
        counter--;
        markDirty();
        return counter;
    }

    public int getCounter(){
        markDirty();
        return counter;
    }

    public SievesBlockTileEntity() {
        super(ModTileEntitiesType.sievesBlockTileEntityType);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        counter = compound.getInt("sieves");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("sieves",counter);
        super.write(compound);
        return compound;
    }

}

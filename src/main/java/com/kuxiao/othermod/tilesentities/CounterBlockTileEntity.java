package com.kuxiao.othermod.tilesentities;

import com.kuxiao.othermod.Init.ModTileEntitiesType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class CounterBlockTileEntity extends TileEntity {

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


    public CounterBlockTileEntity() {
        super(ModTileEntitiesType.counterBlockTileEntityType);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        counter = compound.getInt("counter");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("counter",counter);
        super.write(compound);
        return compound;
    }

}

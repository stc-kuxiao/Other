package com.kuxiao.othermod.blocks.Tofu;

import com.kuxiao.othermod.Init.ModItems;
import com.kuxiao.othermod.base.BaseBlock;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class TofuBlockTender extends BaseBlock {
    public TofuBlockTender(String name) {
        super(name, Material.CLAY, 0, ToolType.SHOVEL, 0.8f, SoundType.SLIME);

    }


    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!Utils.isCreativeMode(player) && !worldIn.isRemote){
            Utils.dropItem(worldIn,pos, ModItems.tofuTender,4);
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    /**
     * 不同程度的fallDistance值：
     * 从低一格跳上去           0.22777925
     * 从高半格的地方走下去     0.46415937
     * 在方块上跳一下           1.1278902
     * 从10格高的地方跳下       9.667067
     * 从20格高的地方跳下       18.772945
     * 注：按住shift不会触发此函数
     * @param worldIn
     * @param pos
     * @param entityIn
     * @param fallDistance
     */
    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if(entityIn instanceof PlayerEntity && !worldIn.isRemote){
            if(fallDistance >0.5f){
                worldIn.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
                Utils.dropItem(worldIn,pos, ModItems.tofuTender,worldIn.rand.nextInt(3)+1);
            }
        }
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
    }


}

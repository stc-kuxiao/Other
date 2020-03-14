package com.kuxiao.othermod.fluids;

import com.kuxiao.othermod.Othermod;
import com.kuxiao.othermod.Util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


/**
 * @author kuxiao
 * name: 流体名称，最终会产生一个 <name>_bucket 的物品，记得去添加材质
 * stillPath: 流体静止时贴图，传输路径为 <modid>:block/'path' |默认minecraft:block/brown_mushroom_block
 * flowPath:  流体流动时贴图，传输路径为 <modid>:block/'path' |默认minecraft:block/mushroom_stem
 * color: 8位16进制颜色代码|默认0xFFFFFFFF
 */
public class Dis_FluidInitForge {
    private static String name = "baen_milk";
    private static int color = 0xFFFFFFFF;
    private static String stillPath = "minecraft:block/brown_mushroom_block";
    private static String flowPath = "minecraft:block/mushroom_stem";


    private static ResourceLocation fluidStill = new ResourceLocation(stillPath);
    private static ResourceLocation fluidFlowing = new ResourceLocation(flowPath);

    public static DeferredRegister<Block> blocks = new DeferredRegister<>(ForgeRegistries.BLOCKS, Othermod.MODID);
    public static DeferredRegister<Item> items = new DeferredRegister<>(ForgeRegistries.ITEMS, Othermod.MODID);
    public static DeferredRegister<Fluid> fluids = new DeferredRegister<>(ForgeRegistries.FLUIDS, Othermod.MODID);

    private static RegistryObject<FlowingFluid> testFluid = fluids.register(name, () ->
            new ForgeFlowingFluid.Source(Dis_FluidInitForge.testFluidProperties)
    );
    private static RegistryObject<FlowingFluid> testFluidFlowing = fluids.register(name+"_flowing", () ->
            new ForgeFlowingFluid.Flowing(Dis_FluidInitForge.testFluidProperties)
    );

    private static RegistryObject<FlowingFluidBlock> testFluidBlock = blocks.register(name+"_block", () ->
            new FlowingFluidBlock(testFluid, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops())
    );
    private static RegistryObject<Item> testFluidBucket = items.register(name+"_bucket", () ->
            new BucketItem(testFluid, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(Utils.itemGroup))
    );

    private static ForgeFlowingFluid.Properties testFluidProperties =
            new ForgeFlowingFluid.Properties(testFluid, testFluidFlowing, FluidAttributes.builder(fluidStill, fluidFlowing).color(color))
                    .bucket(testFluidBucket).block(testFluidBlock);


}

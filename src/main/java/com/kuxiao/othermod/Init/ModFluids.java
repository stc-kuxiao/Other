package com.kuxiao.othermod.Init;

import com.kuxiao.othermod.Othermod;
import com.kuxiao.othermod.fluids.BeanMilk;
import com.kuxiao.othermod.fluids.OilFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@ObjectHolder(Othermod.MODID)
public class ModFluids {
    public static class Tags{
        public static final Tag<Fluid> OIL = new FluidTags.Wrapper(new ResourceLocation(Othermod.MODID,"oil"));
        public static final Tag<Fluid> BEAN_MILK = new FluidTags.Wrapper(new ResourceLocation(Othermod.MODID,"bean_milk"));
    }

    public static final OilFluid.Flowing FLOWING_OIL = null;
    public static final BeanMilk.Flowing FLOWING_BEAN_MILK = null;
    public static final OilFluid.Source OIL = null;
    public static final BeanMilk.Source BEAN_MILK = null;


    @Mod.EventBusSubscriber(modid = Othermod.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register{

        @SubscribeEvent
        public static void registerFluids(RegistryEvent.Register<Fluid> event){
            Fluid[] fluids = {
                new OilFluid.Flowing().setRegistryName(Othermod.MODID,"flowing_oil"),
                new BeanMilk.Flowing().setRegistryName(Othermod.MODID,"flowing_bean_milk"),
                new OilFluid.Source().setRegistryName(Othermod.MODID,"oil"),
                new BeanMilk.Source().setRegistryName(Othermod.MODID,"bean_milk")
            };
            event.getRegistry().registerAll(fluids);
        }

    }


}

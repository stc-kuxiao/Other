package com.kuxiao.othermod;

import com.kuxiao.othermod.Init.ComposterItems;
import com.kuxiao.othermod.Init.ModBlocks;
import com.kuxiao.othermod.proxy.ClientProxy;
import com.kuxiao.othermod.proxy.IProxy;
import com.kuxiao.othermod.proxy.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.kuxiao.othermod.world.gen.WorldGenOre.setupOreGenerationOverWorld;

@Mod(Othermod.MODID)
public class Othermod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "othermod";
    public static IProxy proxy = DistExecutor.runForDist(()-> ClientProxy::new,()-> ServerProxy::new);

    public Othermod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
        proxy.init();
        ComposterItems.register();
        setupOreGenerationOverWorld(ModBlocks.expOre,20,1,20,128);
    }

}

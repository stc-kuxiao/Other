package com.kuxiao.othermod;

import com.kuxiao.othermod.Init.ComposterItems;
import com.kuxiao.othermod.Util.RegisterHandler;
import com.kuxiao.othermod.proxy.ClientProxy;
import com.kuxiao.othermod.proxy.IProxy;
import com.kuxiao.othermod.proxy.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Othermod.MODID)
public class Othermod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "othermod";
    public static IProxy proxy = DistExecutor.runForDist(()-> ClientProxy::new,()-> ServerProxy::new);

    public Othermod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event){
        proxy.init();
        ComposterItems.register();
        RegisterHandler.onOreRegistery();
        RegisterHandler.onTreeRegistery();


    }



}

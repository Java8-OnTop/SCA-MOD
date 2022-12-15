package com.xss6.sca;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.xss6.sca.event.processor.EventProcessor;
import com.xss6.sca.networking.proxy.ScaProxy;
import com.xss6.sca.event.Events;
import com.xss6.sca.setting.Settings;
import com.xss6.sca.hack.Hacks;
import com.xss6.sca.manager.PositionManager;

import org.lwjgl.opengl.Display;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = ScaMod.MODID, name = ScaMod.NAME, version = ScaMod.VERSION)
public class ScaMod
{
    //modinfo
    public static final String MODID = "sca";
    public static final String NAME = "SCA MOD";
    public static final String VERSION = "0.0.1";

    //events
    public static EventProcessor EVENT_PROCESSOR;
    public static Events EVENTS;
    
    //others
    public static ScaProxy PROXY;
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    //settings
    public static Settings SETTINGS;
    
    //hacks
    public static Hacks HACKS;
    
    
    //managers
    public static PositionManager POS_MANAGER;
    
    @Mod.Instance
    public static ScaMod INSTANCE;
    Minecraft mc = Minecraft.getMinecraft();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	LOGGER.info("Loading " + NAME);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	this.load();
    	LOGGER.info(NAME + " : " + VERSION + " has been loaded!");
    	Display.setTitle("SCA TOOLS | v" + VERSION);
    }
    
    public void load()
    {
    	EVENT_PROCESSOR = new EventProcessor();
        EVENTS = new Events();
        HACKS = new Hacks();
        this.loadManagers();
    }
    
    public void unLoad()
    {
    	LOGGER.info(NAME + " : " + VERSION + " has been unloaded!");
    }
    
    void loadManagers()
    {
        POS_MANAGER = new PositionManager();
    }
}

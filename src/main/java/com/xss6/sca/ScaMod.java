package com.xss6.sca;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.xss6.sca.event.processor.EventProcessor;

import org.lwjgl.opengl.Display;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = ScaMod.MODID, name = ScaMod.NAME, version = ScaMod.VERSION)
public class ScaMod
{
    public static final String MODID = "sca";
    public static final String NAME = "SCA MOD";
    public static final String VERSION = "0.0.1";

    public static EventProcessor EVENT_PROCESSOR;
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
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
    }
    
    public void unLoad()
    {
    	LOGGER.info(NAME + " : " + VERSION + " has been unloaded!");
    }
}

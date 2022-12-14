package com.xss6.sca;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.xss6.sca.event.EventProcessor;

@Mod(modid = ScaMod.MODID, name = ScaMod.NAME, version = ScaMod.VERSION)
public class ScaMod
{
    public static final String MODID = "sca";
    public static final String NAME = "SCA MOD";
    public static final String VERSION = "0.0.1";

    public static EventProcessor EVENT_PROCESSOR;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	System.out.println("Starting: " + NAME + " V: " + VERSION);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	System.out.println("Started: " + NAME + " V: " + VERSION);
    }
}

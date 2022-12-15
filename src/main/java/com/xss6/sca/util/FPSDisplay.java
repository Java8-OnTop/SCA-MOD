package com.xss6.sca.util;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class FPSDisplay {
	Minecraft mc = Minecraft.getMinecraft();
	
	int fps = Integer.valueOf(Minecraft.getDebugFPS());
	
	void showFPS()
	{
		int x = 0;
		while(x < 100)
		{
			drawString(mc.fontRenderer, "FPS: \247f" + fps, width / 24, (height / 20) - 4, Integer.parseInt("OOFFOO", 16));
		}
	}
}

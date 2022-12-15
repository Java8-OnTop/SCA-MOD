package com.xss6.sca.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.mojang.realmsclient.gui.ChatFormatting;

public class HudUtil implements Globals {
  public static String getFpsLine() {
        String line = "";
        int fps = Minecraft.getDebugFPS();
        if (fps > 120) {
            line += ChatFormatting.GREEN;
        } else if (fps > 60) {
            line += ChatFormatting.YELLOW;
        } else {
            line += ChatFormatting.RED;
        }
        return line + " " + fps;
    }
}

package com.xss6.sca.hack.hacks.chat;

import com.xss6.sca.hack.Hack;
import com.xss6.sca.*;

public class ToggleMessages extends Hack{
  
  double dDelayTimer = 0.1;
  
  public ToggleMessages() {
    super(ToggleMessages());
  }
  
  void onEnable() {
    system.Out.println("ToggleMessages Enabled");
  }
  
  void onToggle() {
    if(Hack.getHackByName("Toggle Messages").isEnabled()) {
      Hack.getHackByName("Toggle Messages").Disable();
    }
    else {
    }
  }
}

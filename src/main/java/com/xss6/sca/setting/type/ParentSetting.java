package com.xss6.sca.setting.type;

import com.xss6.sca.hack.Hack;
import com.xss6.sca.setting.Setting;

import java.util.function.Predicate;

public class ParentSetting extends Setting<Boolean> {

    public ParentSetting(String name, Hack parent) {
        super(name, false, parent);
    }

    public void toggle() {
        value = !value;
    }

    public boolean isShown(){
        return true;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String getType() {
        return "boolean";
    }
}

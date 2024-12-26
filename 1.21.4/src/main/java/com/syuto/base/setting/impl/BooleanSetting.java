package com.syuto.base.setting.impl;

import com.syuto.base.setting.Setting;
import com.syuto.base.setting.api.SettingHolder;

import java.util.function.BooleanSupplier;

public class BooleanSetting extends Setting<Boolean> {
    public BooleanSetting(String name, SettingHolder parent, BooleanSupplier visibility, Boolean value) {
        super(name, parent, visibility, value);
    }
    public BooleanSetting(String name, SettingHolder parent, Boolean defaultValue) {
        super(name, parent, defaultValue);
    }
    public void toggle() {
        setValue(!value);
    }
}

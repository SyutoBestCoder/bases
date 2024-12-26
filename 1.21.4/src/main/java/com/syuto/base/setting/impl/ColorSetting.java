package com.syuto.base.setting.impl;

import com.syuto.base.setting.Setting;
import com.syuto.base.setting.api.SettingHolder;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.function.BooleanSupplier;

public class ColorSetting extends Setting<Color> {

    public float hue, saturation, brightness;

    public ColorSetting(String name, SettingHolder parent, BooleanSupplier visibility, Color defaultValue) {
        super(name, parent, visibility, defaultValue);
        setValue(defaultValue);
    }

    public ColorSetting(String name, SettingHolder parent, Color defaultValue) {
        super(name, parent, defaultValue);
        setValue(defaultValue);
    }

    public void set(float[] hsb) {
        set(hsb[0], hsb[1], hsb[2]);
    }

    public void set(float hue, float saturation, float brightness) {
        this.hue = hue;
        this.saturation = saturation;
        this.brightness = brightness;
    }

    @Override
    public Color getValue() {
        return Color.getHSBColor(hue, saturation, brightness);
    }
    @Override
    public void setValue(@NotNull Color value) {
        final float[] hsb = new float[3];
        set(Color.RGBtoHSB(value.getRed(), value.getGreen(), value.getBlue(), hsb));
    }

}

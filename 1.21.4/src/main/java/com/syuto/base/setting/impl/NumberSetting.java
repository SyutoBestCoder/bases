package com.syuto.base.setting.impl;

import com.syuto.base.setting.Setting;
import com.syuto.base.setting.api.SettingHolder;
import lombok.Getter;

import java.util.function.BooleanSupplier;

import static java.lang.Math.*;

@Getter
public class NumberSetting extends Setting<Number> {

    public final Number minValue, maxValue, increment;

    public NumberSetting(String name, SettingHolder parent, BooleanSupplier visibility, Number defaultValue, Number minValue, Number maxValue, Number increment) {
        super(name, parent, visibility, defaultValue);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.increment = increment;
    }
    public NumberSetting(String name, SettingHolder parent, Number defaultValue, Number minValue, Number maxValue, Number increment) {
        super(name, parent, defaultValue);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.increment = increment;
    }

    @Override
    public void setValue(Number value) {
        double precision = 1 / increment.doubleValue();
        super.setValue(max(minValue.doubleValue(), min(maxValue.doubleValue(), round(value.doubleValue() * precision) / precision)));
    }

}

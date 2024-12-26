package com.syuto.base.setting;

import com.syuto.base.setting.api.SettingHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.BooleanSupplier;

@Getter
@Setter
@AllArgsConstructor
public abstract class Setting<T> {
    public final String name;
    public final SettingHolder parent;
    public final BooleanSupplier visibility;
    public T value;

    protected Setting(String name, SettingHolder parent, T defaultValue) {
        this(name, parent, () -> true, defaultValue);
        parent.values.add(this);
    }

}

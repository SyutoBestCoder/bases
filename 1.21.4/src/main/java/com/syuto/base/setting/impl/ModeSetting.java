package com.syuto.base.setting.impl;

import com.syuto.base.setting.Setting;
import com.syuto.base.setting.api.SettingHolder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

@Getter
public class ModeSetting extends Setting<String> {

    public final List<String> modes = new ArrayList<>();

    public ModeSetting(String name, SettingHolder parent, BooleanSupplier visibility, String @NotNull ... values) {
        super(name, parent, visibility, values[0]);
        modes.addAll(List.of(values));
    }
    public ModeSetting(String name, SettingHolder parent, String @NotNull ... values) {
        super(name, parent, values[0]);
        modes.addAll(List.of(values));
    }

    @Override
    public void setValue(String value) {
        if (modes.contains(value)) {
            this.value = value;
        }
    }

    public void next() {
        int index = modes.indexOf(value);
        if (index < modes.size() - 1) {
            setValue(modes.get(index + 1));
        } else {
            setValue(modes.getFirst());
        }
    }
    public void previous() {
        int index = modes.indexOf(value);
        if (index > 0) {
            setValue(modes.get(index - 1));
        } else {
            setValue(modes.getLast());
        }
    }
    public boolean is(final String value) {
        return this.value.equalsIgnoreCase(value);
    }
    public boolean isNot(final String value) {
        return !is(value);
    }

}

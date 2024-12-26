package com.syuto.base.setting.api;

import com.syuto.base.setting.Setting;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class SettingHolder {
    public final List<Setting<?>> values = new ArrayList<>();
    @Nullable
    @SuppressWarnings("unchecked")
    public <S extends Setting<?>> S getSetting(final String name) {
        return (S) this.values.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}

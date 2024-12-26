package com.syuto.base.module;

import com.syuto.base.Base;
import com.syuto.base.module.api.Category;
import com.syuto.base.setting.api.SettingHolder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.minecraft.client.MinecraftClient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public abstract class Module extends SettingHolder {

    protected final MinecraftClient mc = MinecraftClient.getInstance();
    protected float partialTicks = mc.getRenderTickCounter().getTickDelta(true);
    public final String name, description;
    public final Category category;
    public boolean enabled;
    public int key;

    private Supplier<String> suffix = () -> "";

    protected void onEnable() {}
    protected void onDisable() {}

    public final void toggle() {
        setEnabled(!enabled);
    }

    public final void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (this.enabled) {
                onEnable();
                Base.INSTANCE.eventBus.register(this);
            } else {
                Base.INSTANCE.eventBus.unregister(this);
                onDisable();
            }
        }
    }

    @NotNull
    public String getSuffix() {
        return suffix.get();
    }
}

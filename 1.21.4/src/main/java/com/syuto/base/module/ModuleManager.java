package com.syuto.base.module;

import com.syuto.base.Base;
import org.jetbrains.annotations.Nullable;
import org.reflections.Reflections;

import java.util.*;

public class ModuleManager {

    public static final List<Module> modules = new ArrayList<>();

    public static void registerModules() {
        Reflections reflections = new Reflections("com.syuto.base.module.impl");
        Set<Class<? extends Module>> moduleClasses = reflections.getSubTypesOf(Module.class);
        for (Class<? extends Module> moduleClass : moduleClasses) {
            try {
                Module module = moduleClass.getDeclaredConstructor().newInstance();
                modules.add(module);
            } catch (Exception e) {
                Base.LOGGER.error("Error registering modules.", e.getCause());
            }
        }
        modules.sort(Comparator.comparing(Module::getName));
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public static <M extends Module> M getModule(Class<M> module) {
        return (M) modules.stream()
                .filter(m -> m.getClass().equals(module))
                .findFirst()
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public static <M extends Module> M getModule(String module) {
        return (M) modules.stream()
                .filter(m -> m.getName().equalsIgnoreCase(module))
                .findFirst()
                .orElse(null);
    }

}

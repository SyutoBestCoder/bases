package com.syuto.base.eventbus;

import com.syuto.base.Base;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {

    private final Map<Class<?>, List<MethodListener>> listeners = new ConcurrentHashMap<>();

    private record MethodListener(Object target, Method method) {

        void invoke(Object event) {
                try {
                    method.setAccessible(true);
                    method.invoke(target, event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    public void register(Object listener) {
        Method[] methods = listener.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(EventHandler.class)) {
                Class<?>[] params = method.getParameterTypes();
                if (params.length == 1 && Event.class.isAssignableFrom(params[0])) {
                    listeners.computeIfAbsent(params[0], k -> new CopyOnWriteArrayList<>())
                            .add(new MethodListener(listener, method));
                }
            }
        }
    }

    public void unregister(Object listener) {
        listeners.values().forEach(methodListeners ->
                methodListeners.removeIf(methodListener -> {
                    if (methodListener.target == listener) {
                        return true;
                    }
                    return false;
                })
        );
        listeners.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    public void post(Event event) {
        List<MethodListener> eventListeners = listeners.get(event.getClass());
        if (eventListeners != null) {
            for (MethodListener listener : eventListeners) {
                listener.invoke(event);
            }
        }
    }
}
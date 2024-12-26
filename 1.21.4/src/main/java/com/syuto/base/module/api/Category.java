package com.syuto.base.module.api;

public enum Category {
    COMBAT,
    MOVEMENT,
    PLAYER,
    RENDER,
    MISC;
    public final String properName = name().toUpperCase().charAt(0) + name().toLowerCase().substring(1);
}

package com.syuto.base;

import com.syuto.base.eventbus.EventBus;
import com.syuto.base.module.ModuleManager;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base implements ModInitializer {
	public static final String MOD_ID = "base";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Base INSTANCE;
	public static MinecraftClient mc = MinecraftClient.getInstance();
	public EventBus eventBus;

	public Base() {
		eventBus = new EventBus();
		INSTANCE = this;
	}

	@Override
	public void onInitialize() {
		final long time = System.currentTimeMillis();
		ModuleManager.registerModules();
		LOGGER.info("Initialized {} in {}ms.", MOD_ID, System.currentTimeMillis() - time);
	}
}
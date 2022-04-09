package com.quandz.core;

import com.quandz.config.ConfigManager;
import com.quandz.listener.BlockBreakListener;
import com.quandz.worker.Regenerator;
import org.bukkit.plugin.java.JavaPlugin;

public final class OreRegenerator extends JavaPlugin {

    private ConfigManager configManager;
    private Cache cache;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        cache = new Cache();
        configManager = new ConfigManager(this);
        new BlockBreakListener(this, configManager.getMiningWorlds(), configManager.getMaterials());
        new Regenerator(this, configManager.getRefreshTime());
    }

    @Override
    public void onDisable() {
        cache.restart();
    }

    public Cache getCache() {
        return cache;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}

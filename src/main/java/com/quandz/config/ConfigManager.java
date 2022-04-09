package com.quandz.config;

import com.quandz.core.OreRegenerator;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigManager {

    private final OreRegenerator oreRegenerator;

    private long REFRESH_TIME;
    private List<String> MINING_WORLDS;
    private List<Material> MATERIALS;

    public ConfigManager(OreRegenerator oreRegenerator) {
        this.oreRegenerator = oreRegenerator;
        load();
    }

    public void load() {
        oreRegenerator.saveDefaultConfig();
        FileConfiguration configFile = oreRegenerator.getConfig();
        REFRESH_TIME = configFile.getLong("refresh-time");
        MINING_WORLDS = configFile.getStringList("worlds");
        MATERIALS = configFile.getStringList("regen-blocks")
                .stream().map(Material::getMaterial).toList();
        oreRegenerator.getLogger().info("Material list: " + MATERIALS.toString());
        oreRegenerator.getLogger().info("Refresh time set to: " + REFRESH_TIME + "s");
        oreRegenerator.getLogger().info("Registered worlds: " + MINING_WORLDS.toString());
    }

    public List<Material> getMaterials() {
        return MATERIALS;
    }

    public long getRefreshTime() {
        return REFRESH_TIME;
    }

    public List<String> getMiningWorlds() {
        return MINING_WORLDS;
    }
}

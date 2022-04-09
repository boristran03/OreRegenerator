package com.quandz.worker;

import com.quandz.core.Cache;
import com.quandz.core.OreRegenerator;
import org.bukkit.scheduler.BukkitRunnable;


public class Regenerator extends BukkitRunnable {

    private final OreRegenerator oreRegenerator;

    public Regenerator(OreRegenerator oreRegenerator, long delay) {
        this.oreRegenerator = oreRegenerator;
        this.runTaskTimer(oreRegenerator, delay * 20, delay * 20);
        oreRegenerator.getLogger().info("Worker started");
    }

    @Override
    public void run() {
        Cache cache = oreRegenerator.getCache();
        cache.restart();
    }
}

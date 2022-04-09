package com.quandz.listener;

import com.quandz.core.Cache;
import com.quandz.core.OreRegenerator;
import com.quandz.object.BlockRegeneratorObject;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;

public class BlockBreakListener implements Listener {

    private final OreRegenerator oreRegenerator;
    private final List<String> worlds;
    private final List<Material> materials;

    public BlockBreakListener(OreRegenerator oreRegenerator, List<String> worlds, List<Material> materials) {
        this.oreRegenerator = oreRegenerator;
        this.worlds = worlds;
        this.materials = materials;
        Bukkit.getPluginManager().registerEvents(this, oreRegenerator);
    }

    @EventHandler(ignoreCancelled = true)
    public void onBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player breaker = e.getPlayer();
        Cache cache = oreRegenerator.getCache();

        if(breaker.getGameMode() != GameMode.SURVIVAL) {
            return;
        }
        if(worlds.contains(block.getWorld().getName())) {
            e.setCancelled(true);
        }
        if(materials.contains(block.getType())) {
            cache.addObject(new BlockRegeneratorObject(block.getType(), block.getLocation()));
            Collection<ItemStack> drops = e.getBlock().getDrops(breaker.getInventory().getItemInMainHand(), breaker);
            breaker.getInventory().addItem(drops.toArray(new ItemStack[0]));
            block.setType(Material.BEDROCK);
        }
    }
}

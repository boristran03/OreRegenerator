package com.quandz.object;

import org.bukkit.Location;
import org.bukkit.Material;

public class BlockRegeneratorObject {

    private final Material oldMaterial;
    private final Location location;

    public BlockRegeneratorObject(Material oldMaterial, Location location) {
        this.oldMaterial = oldMaterial;
        this.location = location;
    }

    public Material getOldMaterial() {
        return oldMaterial;
    }

    public Location getLocation() {
        return location;
    }
}

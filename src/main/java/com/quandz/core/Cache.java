package com.quandz.core;

import com.quandz.object.BlockRegeneratorObject;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private final List<BlockRegeneratorObject> objectList = new ArrayList<>();

    public void restart() {
        objectList.forEach((object) -> object.getLocation().getBlock().setType(object.getOldMaterial()));
        Bukkit.broadcast(Component.text("§7[§c§l!§7] §cQuặng tại các khu vực đã được làm mới!"));
        objectList.clear();
    }

    public void addObject(BlockRegeneratorObject object) {
        objectList.add(object);
    }

    public void removeObject(BlockRegeneratorObject object) {
        objectList.remove(object);
    }

    public List<BlockRegeneratorObject> getObjectList() {
        return objectList;
    }
}

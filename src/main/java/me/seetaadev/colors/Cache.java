package me.seetaadev.colors;

import me.seetaadev.colors.color.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    private static final Map<String, Cache> colors = new ConcurrentHashMap<>();
    private final String name;
    private static List<ItemStack> items = new ArrayList<>();
    private static List<String> colorNames = new ArrayList<>();

    public Cache(String name) {
        this.name = name;
    }

    public static void loadItems() {
        colors.forEach((name, cache) -> {
            Color color = Color.fromName(name);
            if(color == null) {
                return;
            }
            ItemStack item = new ItemStack(Material.WOOL, 1, color.getMaterial());
            if(!items.contains(item)) {
                items.add(item);
                colorNames.add(name);
            }
        });
    }

    public boolean addToMap() {
        if(colors.containsKey(name)) {
            return false;
        }
        colors.put(name, this);
        return true;
    }

    public boolean removeFromMap() {
        if(!colors.containsKey(name)) {
            return false;
        }
        colors.remove(name);
        removeColor(name);
        return true;
    }

    public static Cache getCache(String name) {
        Cache cache = colors.get(name);
        if (cache == null) cache = new Cache(name);
        return cache;
    }

    public static List<ItemStack> getColors() {
        loadItems();
        return items;
    }

    public static List<String> getNames() {
        loadItems();
        return colorNames;
    }

    public void removeColor(String name) {
        Color color = Color.fromName(name);
        if(color == null) {
            return;
        }

        loadItems();
        ItemStack item = new ItemStack(Material.WOOL, 1, color.getMaterial());
        if(items.contains(item)) {
            items.remove(item);
            colorNames.remove(name);
        }
    }

}

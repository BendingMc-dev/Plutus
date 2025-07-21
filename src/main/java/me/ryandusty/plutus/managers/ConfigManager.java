package me.ryandusty.plutus.managers;

import me.ryandusty.plutus.Plutus;
import me.ryandusty.plutus.util.ConfigUtil;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;
import java.util.List;


public class ConfigManager {
    private static Plutus plugin;
    public static String title;
    public static int size;
    public static YamlConfiguration config = ConfigUtil.getConfig();

    public ConfigManager(Plutus plugin) {
        this.plugin = plugin;
    }


    public static HashMap<Integer, Material> getFillers() {
        HashMap<Integer, Material> fillers = new HashMap<>();
        ConfigurationSection section = config.getConfigurationSection("shop.gui.fillers");
        if (section != null) {
            for (String materialName : section.getKeys(false)) {
                Material material = Material.valueOf(materialName.toUpperCase());
                List<Integer> slots = config.getIntegerList("shop.gui.fillers." + materialName);
                for (Integer slot : slots) {
                    fillers.put(slot, material);
                }
            }
        }
        return fillers;
    }
    public static void load() {

        title = config.getString("shop.gui.title");
        size = config.getInt("shop.gui.size");


    }
}




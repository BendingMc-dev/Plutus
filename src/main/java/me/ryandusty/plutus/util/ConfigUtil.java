package me.ryandusty.plutus.util;

import me.ryandusty.plutus.Plutus;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigUtil {
    private static Plutus plugin;
    public ConfigUtil(Plutus plugin) {
        this.plugin = plugin;

    }

    public static YamlConfiguration getConfig() {

        File file = new File(plugin.getDataFolder(), "config.yml");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if(!file.exists()) {
            plugin.saveResource("config.yml", false);
        }
            return YamlConfiguration.loadConfiguration(file);
        }
    public static void reload() {
        getConfig();

    }
}



package me.ryandusty.plutus.util;

import me.ryandusty.plutus.Plutus;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {
    private static Plutus plugin;
    public ConfigManager(Plutus plugin) {
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

    }



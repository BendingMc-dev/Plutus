package me.ryandusty.plutus.guis;

import me.ryandusty.plutus.Plutus;
import me.ryandusty.plutus.managers.ConfigManager;
import me.ryandusty.plutus.util.ConfigUtil;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class MainMenu implements InventoryHolder {

    private Plutus plugin;
    private Inventory inventory;
    public static YamlConfiguration config = ConfigUtil.getConfig();

    private int inventorySize = config.getInt("shop.gui.size");
    private static String title = config.getString("shop.gui.title");



    public MainMenu(Plutus plugin) {
        this.plugin = plugin;
    }
    public void mainMenuGui(Plutus plugin) {
        ConfigManager configManager = new ConfigManager(plugin);
        HashMap<Integer, Material> fillers = ConfigManager.getFillers();

        for (HashMap.Entry<Integer, Material> entry : fillers.entrySet()) {
            int slot = entry.getKey();
            Material material = entry.getValue();

            this.inventory.setItem(slot, ItemStack.of(material));
        }


        this.inventory = plugin.getServer().createInventory(this,inventorySize);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}

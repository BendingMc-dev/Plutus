package me.ryandusty.plutus.util;

import me.ryandusty.plutus.Plutus;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class ShopGUI implements InventoryHolder {

    private Plutus plugin;
    private Inventory inventory;
    private int inventorySize = ConfigManager.getConfig().getInt("Gui.Shop.Size");

    public ShopGUI(Plutus plugin) {
        this.plugin = plugin;
    }
    public void shopGui(Plutus plugin) {
        this.inventory = plugin.getServer().createInventory(this,inventorySize);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}

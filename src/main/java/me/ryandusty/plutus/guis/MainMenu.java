package me.ryandusty.plutus.guis;

import me.ryandusty.plutus.Plutus;
import me.ryandusty.plutus.util.ConfigUtil;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MainMenu implements InventoryHolder {

    private Plutus plugin;
    private Inventory inventory;
    private int inventorySize = ConfigUtil.getConfig().getInt("Gui.Shop.Size");

    public MainMenu(Plutus plugin) {
        this.plugin = plugin;
    }
    public void mainMenuGui(Plutus plugin) {
        this.inventory = plugin.getServer().createInventory(this,inventorySize);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}

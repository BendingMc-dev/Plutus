package me.ryandusty.plutus.shop.listener;

import me.ryandusty.plutus.Plutus;
import me.ryandusty.plutus.guis.MainMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class ShopListener implements Listener {
    private static Plutus plugin;
    public ShopListener(Plutus plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();

        if (!(inventory.getHolder(false) instanceof MainMenu mainMenu)) {
            return;
        }

    }



}

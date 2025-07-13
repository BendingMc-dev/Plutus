package me.ryandusty.plutus;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import me.ryandusty.plutus.util.CommandsUtil;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class Plutus extends JavaPlugin {

    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public void onEnable() {

        LiteralCommandNode<CommandSourceStack> buildCommands = Commands.literal("plutus")
                .then(Commands.literal("reload")
                        .then(Commands.literal("version"))
                        .then(Commands.literal("shop"))
                        .then(Commands.literal("ah")))
                .build();

            getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(buildCommands);
        });


        getLogger().info("Plutus has been enabled!");






        if(Bukkit.getPluginManager().getPlugin("Vault") == null) {
            getLogger().info("Vault is not installed, disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().info("PlaceholderAPI is not installed, disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        if(Bukkit.getPluginManager().getPlugin("ItemsAdder") == null) {
            getLogger().info("PlaceholderAPI is not installed...");
        }
        if(Bukkit.getPluginManager().getPlugin("BorealCore") == null) {
            getLogger().info("BorealCore is not installed...");
        }








    }

    @Override
    public void onDisable() {
        getLogger().info("Plutus has been disabled!");

    }
    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }
}

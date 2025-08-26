package me.ryandusty.plutus.util;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import me.ryandusty.plutus.Plutus;
import me.ryandusty.plutus.guis.AuctionHouse;
import me.ryandusty.plutus.guis.MainMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


public class CommandsUtil {
    private static Plutus plugin;


    public CommandsUtil(Plutus plugin) {
        this.plugin = plugin;

    }

    public static void defineCommands() {

        LiteralArgumentBuilder<CommandSourceStack> shop = Commands.literal("shop");
        LiteralArgumentBuilder<CommandSourceStack> reload = Commands.literal("reload");
        LiteralArgumentBuilder<CommandSourceStack> version = Commands.literal("version");
        LiteralArgumentBuilder<CommandSourceStack> ah = Commands.literal("ah");

        LiteralArgumentBuilder<CommandSourceStack> plutus = Commands.literal("plutus")
                .then(shop)
                .then(reload)
                .then(version)
                .then(ah);
    }

    public static void executeCommands() {
        Commands.literal("plutus")
                .then(Commands.literal("reload"))
                .requires(source -> source.hasPermission("plutus.reload"))
                .executes(ctx -> {
                    CommandSender sender = ctx.getSource().getSender();
                    Entity executor = ctx.getSource().getExecutor();
                    CommandSender console = plugin.getServer().getConsoleSender();
                    if (!(executor instanceof Player player) || !(executor.equals(console)) || !player.hasPermission("plutus.reload")) {
                        sender.sendMessage("You don't have the required permissions to execute this command");
                        return Command.SINGLE_SUCCESS;
                    }
                    if (sender == executor) {
                        sender.sendMessage("Reloading Plutus...");
                        ConfigUtil.reload();
                        return Command.SINGLE_SUCCESS;

                    }
                    sender.sendMessage("Plutus reloaded...");
                    return Command.SINGLE_SUCCESS;

                })
                .then(Commands.literal("version"))
                .requires(source -> source.hasPermission("plutus.version"))
                .executes(ctx -> {
                    String version = plugin.getDescription().getVersion();
                    CommandSender sender = ctx.getSource().getSender();
                    CommandSender console = plugin.getServer().getConsoleSender();
                    Entity executor = ctx.getSource().getExecutor();


                    if (!(sender instanceof Player player) || !player.hasPermission("plutus.version") || !player.equals(console)) {
                        sender.sendMessage("You don't have the required permissions to execute this command");
                        return Command.SINGLE_SUCCESS;
                    }
                    if (sender == executor) {
                        sender.sendMessage("Plutus version: " + version);
                        return Command.SINGLE_SUCCESS;
                    }

                    sender.sendMessage("Plutus version: " + version);
                    return Command.SINGLE_SUCCESS;
                }).then(Commands.literal("shop"))
                .requires(source -> source.hasPermission("plutus.shop"))
                .executes(ctx -> {
                    CommandSender sender = ctx.getSource().getSender();
                    CommandSender console = plugin.getServer().getConsoleSender();
                    Entity executor = ctx.getSource().getExecutor();


                    if (!(executor instanceof Player player) || !(executor.equals(console)) || !player.hasPermission("plutus.shop")) {
                        sender.sendMessage("You don't have the required permissions to execute this command");
                        return Command.SINGLE_SUCCESS;
                    }
                    if (sender == executor)

                        sender.sendMessage("Opening shop...");
                    MainMenu mainMenu = new MainMenu(plugin);
                    player.openInventory(mainMenu.getInventory());

                    return Command.SINGLE_SUCCESS;
                }).then(Commands.literal("ah"))
                .requires(source -> source.hasPermission("plutus.ah"))
                .executes(ctx -> {
                    CommandSender sender = ctx.getSource().getSender();
                    CommandSender console = plugin.getServer().getConsoleSender();
                    Entity executor = ctx.getSource().getExecutor();

                    if (!(executor instanceof Player player) || !(executor.equals(console)) || !player.hasPermission("plutus.ah")) {
                        sender.sendMessage("You don't have the required permissions to execute this command");
                        return Command.SINGLE_SUCCESS;
                    }
                    if (sender == executor)

                        sender.sendMessage("Opening auction house...");
                    AuctionHouse auctionHouse = new AuctionHouse(plugin);
                    player.openInventory(auctionHouse.getInventory());

                    return Command.SINGLE_SUCCESS;
                });
    }
}


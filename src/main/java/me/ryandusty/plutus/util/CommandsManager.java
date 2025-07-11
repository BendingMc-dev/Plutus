package me.ryandusty.plutus.util;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import me.ryandusty.plutus.Plutus;

public class CommandsManager {
    private static Plutus plugin;


    public CommandsManager(Plutus plugin) {
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
}

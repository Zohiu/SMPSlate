package de.zohiu.smpslate.commands;

import de.zohiu.smpslate.SMPSlate;
import me.neznamy.tab.api.TabAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// THIS REQUIRES THE TAB PLUGIN. OTHERWISE THE COMMAND WON'T BE LOADED.
public class SetNameCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!SMPSlate.getInstance().getConfig().getBoolean("SetName.enabled")) {
            sender.sendMessage("This command is disabled!");
            return true;
        }

        if (!sender.hasPermission("setname")) {
            sender.sendMessage("You don't have the permission to use this command!");
            return true;
        }

        // Check if the command has the correct number of arguments
        if (args.length < 2) {
            sender.sendMessage("Usage: /setname <player> <name>");
            return true;
        }

        // Get the player argument from the command
        Player targetPlayer = sender.getServer().getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // Get the newname argument from the command
        String newname = String.join(" ", args).substring(args[0].length() + 1);

        // Send the message to the target player
        TabAPI.getInstance().getTablistFormatManager().setName(TabAPI.getInstance().getPlayer(targetPlayer.getUniqueId()), newname);
        targetPlayer.sendMessage(targetPlayer.getName() + " is now called " + ChatColor.translateAlternateColorCodes('&', newname));

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            List<String> playerNames = new ArrayList<>();

            for (Player player : Bukkit.getOnlinePlayers()) {
                playerNames.add(player.getName());
            }
            completions.addAll(playerNames);

        } else if (args.length == 2) {
            completions.add(commandSender.getName());
        }

        return completions;
    }
}

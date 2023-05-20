package de.zohiu.smpslate.commands;

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

public class WhereIsCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!commandSender.hasPermission("whereis")) {
            commandSender.sendMessage("You don't have the permission to use this command!");
            return true;
        }

        // Check if the command has the correct number of arguments
        if (strings.length < 1) {
            commandSender.sendMessage("Usage: /whereis <player>");
            return true;
        }

        // Get the player argument from the command
        Player targetPlayer = commandSender.getServer().getPlayer(strings[0]);
        if (targetPlayer == null) {
            commandSender.sendMessage("Player not found.");
            return true;
        }

        commandSender.sendMessage(ChatColor.GRAY + targetPlayer.getDisplayName() + " is at " +
                Math.floor(targetPlayer.getLocation().getX()) + ", " + Math.floor(targetPlayer.getLocation().getY()) + ", " + Math.floor(targetPlayer.getLocation().getZ()) +
                " in " + targetPlayer.getWorld().getName());
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
        }

        return completions;
    }
}

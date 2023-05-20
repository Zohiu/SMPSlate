package de.zohiu.smpslate.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CoordShareCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!commandSender.hasPermission("coordshare")) {
            commandSender.sendMessage("You don't have the permission to use this command!");
            return true;
        }

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.chat("I am at " +
                    Math.floor(player.getLocation().getX()) + ", " + Math.floor(player.getLocation().getY()) + ", " + Math.floor(player.getLocation().getZ()) +
                    " in " + player.getWorld().getName());
            return true;
        }
        commandSender.sendMessage(ChatColor.RED + "Only players can execute this!");
        return true;
    }
}

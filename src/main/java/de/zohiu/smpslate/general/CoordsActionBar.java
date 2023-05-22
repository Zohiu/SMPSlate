package de.zohiu.smpslate.general;

import de.zohiu.smpslate.SMPSlate;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CoordsActionBar {
    public static void sendCoordBar() {
        if (!SMPSlate.getInstance().getConfig().getBoolean("CoordBar.enabled")) {
            return;
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            float x = (float) Math.round(player.getLocation().getX() * 10.0f) / 10.0f;
            float y = (float) Math.round(player.getLocation().getY() * 10.0f) / 10.0f;
            float z = (float) Math.round(player.getLocation().getZ() * 10.0f) / 10.0f;

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(
                    ChatColor.translateAlternateColorCodes('&', "&7X: &c" + x + " &8| &7Y: &a" + y + " &8| &7Z: &9 " + z)));
        }
    }
}

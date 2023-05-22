package de.zohiu.smpslate.general;

import de.zohiu.smpslate.SMPSlate;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.TablistFormatManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class CustomChat implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (!SMPSlate.getInstance().getConfig().getBoolean("CustomNameFormatting.enabled")) {
            return;
        }

        event.setCancelled(true);

        UUID playerUUID = event.getPlayer().getUniqueId();
        TabPlayer tabplayer = TabAPI.getInstance().getPlayer(playerUUID);

        TablistFormatManager tfm = TabAPI.getInstance().getTablistFormatManager();

        String customname = tfm.getCustomName(tabplayer);
        if (customname == null) {
            customname = event.getPlayer().getDisplayName();
        }

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', customname) + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + event.getMessage());
    }
}

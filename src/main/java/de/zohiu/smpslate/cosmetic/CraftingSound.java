package de.zohiu.smpslate.cosmetic;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftingSound implements Listener {
    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.BLOCK_LARGE_AMETHYST_BUD_BREAK, 1.0f, 1.0f);
        }
    }
}

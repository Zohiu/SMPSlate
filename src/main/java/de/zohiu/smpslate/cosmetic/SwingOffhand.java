package de.zohiu.smpslate.cosmetic;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class SwingOffhand implements Listener {
    @EventHandler
    public void onOffhandSwitch(PlayerSwapHandItemsEvent event) {
        event.getPlayer().swingOffHand();
    }
}

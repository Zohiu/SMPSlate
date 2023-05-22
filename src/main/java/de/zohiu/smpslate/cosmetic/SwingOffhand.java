package de.zohiu.smpslate.cosmetic;

import de.zohiu.smpslate.SMPSlate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class SwingOffhand implements Listener {
    @EventHandler
    public void onOffhandSwitch(PlayerSwapHandItemsEvent event) {
        if (!SMPSlate.getInstance().getConfig().getBoolean("SwingOffhand.enabled")) {
            return;
        }
        event.getPlayer().swingOffHand();
    }
}

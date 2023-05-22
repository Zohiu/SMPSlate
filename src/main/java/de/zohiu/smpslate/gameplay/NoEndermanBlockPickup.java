package de.zohiu.smpslate.gameplay;

import de.zohiu.smpslate.SMPSlate;
import org.bukkit.entity.Enderman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class NoEndermanBlockPickup implements Listener {
    @EventHandler
    public void onEndermanBlockPickup(EntityChangeBlockEvent event) {
        if (!SMPSlate.getInstance().getConfig().getBoolean("NoEndermanBlockPickup.enabled")) {
            return;
        }

        if (event.getEntity() instanceof Enderman) {
            event.setCancelled(true);
        }
    }
}

package de.zohiu.smpslate.gameplay;

import org.bukkit.entity.Enderman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class NoEndermanBlockPickup implements Listener {
    @EventHandler
    public void onEndermanBlockPickup(EntityChangeBlockEvent event) {
        if (event.getEntity() instanceof Enderman) {
            event.setCancelled(true);
        }
    }
}

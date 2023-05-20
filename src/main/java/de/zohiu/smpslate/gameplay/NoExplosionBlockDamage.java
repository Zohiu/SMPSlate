package de.zohiu.smpslate.gameplay;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoExplosionBlockDamage implements Listener {
    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Creeper || event.getEntity() instanceof TNTPrimed) {
            event.setCancelled(true);
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4.0f, false, false);
            return;
        }
    }
}

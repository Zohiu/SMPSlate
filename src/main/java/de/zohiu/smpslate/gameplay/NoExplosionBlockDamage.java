package de.zohiu.smpslate.gameplay;

import de.zohiu.smpslate.SMPSlate;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoExplosionBlockDamage implements Listener {
    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        if (!SMPSlate.getInstance().getConfig().getBoolean("NoExplosionBlockDamage.enabled")) {
            return;
        }

        if (event.getEntity() instanceof Creeper && SMPSlate.getInstance().getConfig().getBoolean("NoExplosionBlockDamage.safe-creepers")) {
            event.setCancelled(true);
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4.0f, false, false);
            return;
        }

        if (event.getEntity() instanceof TNTPrimed && SMPSlate.getInstance().getConfig().getBoolean("NoExplosionBlockDamage.safe-tnt")) {
            event.setCancelled(true);
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4.0f, false, false);
            // return;
        }
    }
}

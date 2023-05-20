package de.zohiu.smpslate.gameplay;

import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

public class BlockCatapult implements Listener {
    @EventHandler
    public void onWalkOn(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation().subtract(0, 1, 0);

        if (player.getWorld().getBlockAt(loc).getBlockData().getMaterial() == Material.EMERALD_BLOCK) {
            player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation(), 50, 0, 1, 0, 0.1, null);
            player.getWorld().spawnParticle(Particle.SPELL_WITCH, player.getLocation(), 50, 0, 0, 0, 0.1, null);
            player.getWorld().spawnParticle(Particle.TOTEM, player.getLocation(), 50, 0, 1, 0, 0.5, null);
            player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, player.getLocation(), 35, 0, 0, 0, 0.1, null);
            player.getWorld().spawnParticle(Particle.FLASH, player.getLocation(), 1, 0, 1, 0, 0.1, null);

            Firework firework = player.getWorld().spawn(player.getLocation(), Firework.class);
            FireworkMeta meta = firework.getFireworkMeta();
            meta.addEffect(FireworkEffect.builder().withColor(Color.PURPLE).withColor(Color.LIME).withColor(Color.AQUA).with(FireworkEffect.Type.STAR).withFlicker().withTrail().build());
            meta.setPower(0);
            firework.setFireworkMeta(meta);

            player.setVelocity(new Vector(0.0, 10.0, 0.0));

        }
    }

    // Disable fall damage on the catapult itself
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                Location loc = event.getEntity().getLocation().subtract(0, 1, 0);
                if (event.getEntity().getWorld().getBlockAt(loc).getBlockData().getMaterial() == Material.EMERALD_BLOCK) {
                    event.setCancelled(true);
                }
            }
        }
    }
}

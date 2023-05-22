package de.zohiu.smpslate.experimental;

import de.zohiu.smpslate.SMPSlate;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class BreedWildWolfs implements Listener {
    @EventHandler
    public void onWolfClick(PlayerInteractAtEntityEvent event) {
        if (!SMPSlate.getInstance().getConfig().getBoolean("BreedWildWolfs.enabled")) {
            return;
        }

        if (event.getRightClicked() instanceof Wolf) {
            Wolf wolf = (Wolf) event.getRightClicked();
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.COOKED_BEEF) {
                wolf.setTamed(true);
                wolf.setOwner(event.getPlayer());
                wolf.setCollarColor(DyeColor.LIGHT_GRAY);
                wolf.setSitting(false);
                wolf.setBreed(true);
                event.getPlayer().getInventory().remove(new ItemStack(Material.COOKED_BEEF, 1));

                // Remove tamed state after 5 seconds
                BukkitScheduler scheduler = Bukkit.getScheduler();
                scheduler.runTaskLater(SMPSlate.getInstance(), () -> wolf.setTamed(false), 100);
            }
        }
    }
}

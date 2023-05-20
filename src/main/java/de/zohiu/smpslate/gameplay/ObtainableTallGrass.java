package de.zohiu.smpslate.gameplay;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ObtainableTallGrass implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() != Material.TALL_GRASS) {
            return;
        }

        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.SHEARS) {
            return;
        }

        event.setDropItems(false);
        event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.TALL_GRASS, 1));
    }
}

package de.zohiu.smpslate;

import de.zohiu.smpslate.cosmetic.CraftingSound;
import de.zohiu.smpslate.cosmetic.SwingOffhand;
import de.zohiu.smpslate.experimental.BreedWildWolfs;
import de.zohiu.smpslate.gameplay.BlockCatapult;
import de.zohiu.smpslate.gameplay.NoEndermanBlockPickup;
import de.zohiu.smpslate.gameplay.NoExplosionBlockDamage;
import de.zohiu.smpslate.gameplay.ObtainableTallGrass;
import de.zohiu.smpslate.general.CoordsActionBar;
import de.zohiu.smpslate.commands.CoordShareCommand;
import de.zohiu.smpslate.commands.WhereIsCommand;
import de.zohiu.smpslate.general.CustomChat;
import de.zohiu.smpslate.commands.SetNameCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SMPSlate extends JavaPlugin {
    public static SMPSlate instance;

    public static SMPSlate getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (getServer().getPluginManager().getPlugin("TAB") != null){
            getLogger().info("TAB detected, enabling name formatting.");
            Objects.requireNonNull(getCommand("setname")).setExecutor(new SetNameCommand());
            Objects.requireNonNull(getCommand("setname")).setTabCompleter(new SetNameCommand());
            getServer().getPluginManager().registerEvents(new CustomChat(), this);
        }

        // Micro features - Commands
        Objects.requireNonNull(getCommand("whereis")).setExecutor(new WhereIsCommand());
        Objects.requireNonNull(getCommand("whereis")).setTabCompleter(new WhereIsCommand());
        Objects.requireNonNull(getCommand("coordshare")).setExecutor(new CoordShareCommand());

        // Micro features - Events
        getServer().getPluginManager().registerEvents(new ObtainableTallGrass(), this);
        getServer().getPluginManager().registerEvents(new NoExplosionBlockDamage(), this);
        getServer().getPluginManager().registerEvents(new NoEndermanBlockPickup(), this);
        getServer().getPluginManager().registerEvents(new BlockCatapult(), this);
        getServer().getPluginManager().registerEvents(new SwingOffhand(), this);
        getServer().getPluginManager().registerEvents(new CraftingSound(), this);
        getServer().getPluginManager().registerEvents(new BreedWildWolfs(), this);

        // Micro features - misc
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, CoordsActionBar::sendCoordBar, 0L, 3L);

        instance = this;
        getLogger().info("Successfully loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

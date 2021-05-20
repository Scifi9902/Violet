package io.github.scifi9902.violet.inventory;

import io.github.scifi9902.violet.VioletPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class InventoryListener implements Listener {

    private final VioletPlugin instance;

    /**
     * Constructs a new {@link InventoryListener} instance
     *
     * @param instance instance of the plugin
     */
    public InventoryListener(VioletPlugin instance) {
        this.instance = instance;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDeath(PlayerDeathEvent event) {
        instance.getInventoryHandler().savePlayerInventory(event.getEntity());
    }
}

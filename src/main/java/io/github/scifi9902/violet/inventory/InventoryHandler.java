package io.github.scifi9902.violet.inventory;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class InventoryHandler {

    private final Map<UUID, PlayerInventory> playerInventoryMap = new ConcurrentHashMap<>();

    /**
     * Constructs a new {@link InventoryHandler} instance
     *
     * @param uuid uuid of the player
     * @return the players inventory before their last death
     */
    public PlayerInventory getPlayerInventory(UUID uuid) {
        return this.playerInventoryMap.getOrDefault(uuid, null);
    }

    /**
     * Save a players inventory to the map
     *
     * @param player player to save inventory of
     */
    public void savePlayerInventory(Player player) {
        org.bukkit.inventory.PlayerInventory playerInventory = player.getInventory();
        playerInventoryMap.put(player.getUniqueId(), new PlayerInventory(playerInventory.getArmorContents(), playerInventory.getContents()));
    }
}

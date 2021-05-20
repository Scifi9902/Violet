package io.github.scifi9902.violet.inventory;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class PlayerInventory {

    private final ItemStack[] armorContents;

    private final ItemStack[] inventoryContents;

    /**
     * Constructs a new {@link PlayerInventory} instance
     *
     * @param armorContents the players armor contents
     * @param inventoryContents the players inventory contents
     */
    public PlayerInventory(ItemStack[] armorContents, ItemStack[] inventoryContents) {
        this.armorContents = armorContents;
        this.inventoryContents = inventoryContents;
    }
}

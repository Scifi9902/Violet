package io.github.scifi9902.violet;

import io.github.scifi9902.command.CommandHandler;
import io.github.scifi9902.violet.command.RefundCommand;
import io.github.scifi9902.violet.inventory.InventoryHandler;
import io.github.scifi9902.violet.inventory.InventoryListener;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class VioletPlugin extends JavaPlugin {

    private CommandHandler commandHandler;

    private InventoryHandler inventoryHandler;

    public void onEnable() {
        this.commandHandler = new CommandHandler(this, "violet");
        this.inventoryHandler = new InventoryHandler();
        this.registerCommands();
        this.registerListeners();
    }

    private void registerCommands() {
        this.commandHandler.registerCommand(new RefundCommand(this));
    }

    private void registerListeners() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new InventoryListener(this),this);
    }


}

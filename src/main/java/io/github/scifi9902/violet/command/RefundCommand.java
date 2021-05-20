package io.github.scifi9902.violet.command;

import io.github.scifi9902.command.annotations.Command;
import io.github.scifi9902.command.annotations.Parameter;
import io.github.scifi9902.violet.VioletPlugin;
import io.github.scifi9902.violet.inventory.PlayerInventory;
import io.github.scifi9902.violet.utils.CC;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RefundCommand {

    private final VioletPlugin instance;

    /**
     * Constructs a new {@link RefundCommand} instance
     *
     * @param instance instance of the plugin
     */
    public RefundCommand(VioletPlugin instance) {
        this.instance = instance;
    }

    @Command(name = "refund", aliases = {"inventoryrestore", "invrestore", "restore"}, permission = "violet.command.refund")
    public void execute(CommandSender sender, @Parameter(name = "target") Player target) {
        if (target == null) {
            sender.sendMessage(CC.chat("&cPlayer is not online."));
            return;
        }

        PlayerInventory inventory = instance.getInventoryHandler().getPlayerInventory(target.getUniqueId());

        if (inventory == null) {
            sender.sendMessage(CC.chat("&cFailed to find an inventory for that player, have they died recently?"));
            return;
        }

        target.getInventory().setArmorContents(inventory.getArmorContents());
        target.getInventory().setContents(inventory.getInventoryContents());
        instance.getInventoryHandler().getPlayerInventoryMap().remove(target.getUniqueId());
        sender.sendMessage(CC.chat("&eYou have successfully refunded &f" + target.getName() + "&e."));
    }

}

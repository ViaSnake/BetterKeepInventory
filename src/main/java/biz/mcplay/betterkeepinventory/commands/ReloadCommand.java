package biz.mcplay.betterkeepinventory.commands;

import biz.mcplay.betterkeepinventory.BetterKeepInventory;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private final BetterKeepInventory plugin;

    public ReloadCommand(BetterKeepInventory plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("betterkeepinventory.reload")) {
                plugin.loadConfig();
                player.sendMessage(ChatColor.GREEN + "BetterKeepInventory config reloaded!");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        } else {
            plugin.loadConfig();
            sender.sendMessage(ChatColor.GREEN + "BetterKeepInventory config reloaded!");
        }

        return false;
    }
}

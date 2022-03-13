package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NoBlocksEventCommand implements CommandExecutor {
    Main plugin;

    public NoBlocksEventCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.noBlock = !plugin.noBlock;
        sender.sendMessage(plugin.noBlock ? ChatColor.GREEN + "on event" : ChatColor.RED + "off event");
        return true;
    }
}

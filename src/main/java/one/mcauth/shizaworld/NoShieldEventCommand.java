package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NoShieldEventCommand implements CommandExecutor {
    Main plugin;

    public NoShieldEventCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.noShield = !plugin.noShield;
        sender.sendMessage(plugin.noShield ? ChatColor.GREEN + "on event" : ChatColor.RED + "off event");
        return true;
    }
}

package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SpawnOnlySalmonEventCommand implements CommandExecutor {
    Main plugin;

    public SpawnOnlySalmonEventCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.spawnOnlySalmon = !plugin.spawnOnlySalmon;
        sender.sendMessage(plugin.spawnOnlySalmon ? ChatColor.GREEN + "on event" : ChatColor.RED + "off event");
        return true;
    }
}

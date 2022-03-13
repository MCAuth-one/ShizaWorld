package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SpawnOnlySkeletonEventCommand implements CommandExecutor {
    Main plugin;

    public SpawnOnlySkeletonEventCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.spawnOnlySkeletons = !plugin.spawnOnlySkeletons;
        sender.sendMessage(plugin.spawnOnlySkeletons ? ChatColor.GREEN + "on event" : ChatColor.RED + "off event");
        return true;
    }
}

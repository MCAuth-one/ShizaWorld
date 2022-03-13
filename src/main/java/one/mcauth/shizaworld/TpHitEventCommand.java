package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TpHitEventCommand implements CommandExecutor {
    Main plugin;

    public TpHitEventCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.tpHit = !plugin.tpHit;
        sender.sendMessage(plugin.tpHit ? ChatColor.GREEN + "on event" : ChatColor.RED + "off event");
        return true;
    }
}

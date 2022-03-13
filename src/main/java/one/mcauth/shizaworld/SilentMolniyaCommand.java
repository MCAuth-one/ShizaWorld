package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class SilentMolniyaCommand implements CommandExecutor {
    Main plugin;

    public SilentMolniyaCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.silentMolniya = !plugin.silentMolniya;
        sender.sendMessage(plugin.silentMolniya ? ChatColor.GREEN + "on silent mode" : ChatColor.RED + "off silent mode");
        return true;
    }
}

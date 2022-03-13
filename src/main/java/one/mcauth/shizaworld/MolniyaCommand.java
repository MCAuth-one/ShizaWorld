package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class MolniyaCommand implements CommandExecutor {
    Main plugin;

    public MolniyaCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;
        String nickname = String.join(" ", args);
        Player player = sender.getServer().getPlayer(nickname);
        if (player == null) {
            sender.sendMessage(ChatColor.RED + "Cannot find player.");
            return true;
        }
        LightningStrike lightning = (LightningStrike)player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);
        //player.damage(4d, lightning);
        return true;
    }
}

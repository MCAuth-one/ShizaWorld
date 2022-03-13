package one.mcauth.shizaworld;

import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TheHellCommand implements CommandExecutor {
    Main plugin;

    public TheHellCommand(Main main) {
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
        for (int i = 0; i < 5; i++) {
            for (Sound sound : Sound.values()) {
                player.playSound(player.getLocation(), sound, 2f, 0.5f);
            }
        }
        return true;
    }
}

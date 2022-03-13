package one.mcauth.shizaworld;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class ArtyomMP4Command implements CommandExecutor {
    Main plugin;

    public ArtyomMP4Command(Main main) {
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
        for (int i = 0; i < 1000; i++) {
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
        }
        for (int i = 0; i < 200; i++) {
            //player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 1000000);
        }
        return true;
    }
}

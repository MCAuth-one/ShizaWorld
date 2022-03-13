package one.mcauth.shizaworld;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class ArtyomAMCommand implements CommandExecutor {
    Main plugin;

    public ArtyomAMCommand(Main main) {
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
        PacketContainer packet = plugin.manager.createPacket(PacketType.Play.Server.GAME_STATE_CHANGE);
        packet.getIntegers().write(0, 4);
        packet.getFloat().write(0, 104f);
        try {
            plugin.manager.sendServerPacket(player, packet);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return true;
    }
}

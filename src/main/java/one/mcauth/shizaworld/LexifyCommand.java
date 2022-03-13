package one.mcauth.shizaworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class LexifyCommand implements CommandExecutor {
    Main plugin;

    public LexifyCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;
        String nickname = String.join(" ", args);
        if (!plugin.isLexified.containsKey(nickname)) plugin.isLexified.put(nickname, false);
        plugin.isLexified.put(nickname, !plugin.isLexified.get(nickname));
        return true;
    }
}

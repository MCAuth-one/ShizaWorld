package one.mcauth.shizaworld;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NFTCommand implements CommandExecutor {
    Main plugin;

    public NFTCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            ((Player)sender).kickPlayer("You think it's funny to take screenshots of people's NFTs, huh? Property theft is a joke to you? I'll have you know that the blockchain doesn't lie. I own it. Even if you save it, it's my property. You are mad that you don't own the art that I own. Delete that screenshot.");
        }
        return true;
    }
}

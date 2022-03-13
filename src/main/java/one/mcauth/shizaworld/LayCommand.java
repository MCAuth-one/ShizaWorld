package one.mcauth.shizaworld;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LayCommand implements CommandExecutor {
    Main plugin;

    public LayCommand(Main main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player)sender);
            player.playSound(player.getLocation(), Sound.ENTITY_TNT_PRIMED, 1f, 1f);
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 5));
            player.setHealth(1d);
        }
        return true;
    }
}

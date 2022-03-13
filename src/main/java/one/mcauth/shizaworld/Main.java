package one.mcauth.shizaworld;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main extends JavaPlugin {
    public boolean silentMolniya = false;
    public boolean spawnOnlySkeletons = false;
    public boolean spawnOnlySalmon = false;
    public boolean noBlock = false;
    public boolean noShield = false;
    public boolean tpHit = false;
    public ProtocolManager manager;
    public HashMap<String, Boolean> isLexified = new HashMap<>();
    private final Map<InetSocketAddress, Integer> playerVersions = new ConcurrentHashMap<InetSocketAddress, Integer>();

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.GREEN + "Enabling ShizaWorld - shiza4u.");
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        this.getCommand("molniya0207").setExecutor(new MolniyaCommand(this));
        this.getCommand("silentmolniya").setExecutor(new SilentMolniyaCommand(this));
        this.getCommand("sit").setExecutor(new SitCommand(this));
        this.getCommand("lay").setExecutor(new LayCommand(this));
        this.getCommand("nft").setExecutor(new NFTCommand(this));
        this.getCommand("spawnonlyskeletonevent").setExecutor(new SpawnOnlySkeletonEventCommand(this));
        this.getCommand("spawnonlysalmonevent").setExecutor(new SpawnOnlySalmonEventCommand(this));
        this.getCommand("noblockevent").setExecutor(new NoBlocksEventCommand(this));
        this.getCommand("noshieldmayevent").setExecutor(new NoShieldEventCommand(this));
        this.getCommand("artyomfm").setExecutor(new ArtyomFMCommand(this));
        this.getCommand("artyomam").setExecutor(new ArtyomAMCommand(this));
        this.getCommand("artyommp4").setExecutor(new ArtyomMP4Command(this));
        this.getCommand("thehell").setExecutor(new TheHellCommand(this));
        this.getCommand("tphitevent").setExecutor(new TpHitEventCommand(this));
        this.getCommand("lexify").setExecutor(new LexifyCommand(this));
        this.saveDefaultConfig();
        manager = ProtocolLibrary.getProtocolManager();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

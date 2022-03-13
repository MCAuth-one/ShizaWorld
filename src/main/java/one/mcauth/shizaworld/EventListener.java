package one.mcauth.shizaworld;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
    Main plugin;

    public EventListener(Main main) {
        plugin = main;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity ent = event.getEntity();
        if (ent instanceof Player && event.getDamager().getType() == EntityType.LIGHTNING && !plugin.silentMolniya) {
            ent.sendMessage(ChatColor.RED + "zhopa: в вас ударила молния");
        }
        if (plugin.tpHit) {
            Entity ent2 = event.getDamager();
            var d = Math.random();
            var dx = Math.random();
            if (d < 0.33) {
                ent.getWorld().playSound(ent.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                ent.teleport(ent.getLocation().add(d * 5, 0, 0));
            } else if (d > 0.7) {
                ent.getWorld().playSound(ent.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                ent.teleport(ent.getLocation().add(0, 0, d * 5));
            } else {
                ent.getWorld().playSound(ent.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                ent.teleport(ent.getLocation().add(d * 5, 0, d * 5));
            }
            if (dx < 0.33) {
                ent2.getWorld().playSound(ent2.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                ent2.teleport(ent2.getLocation().add(dx * 5, 0, 0));
            } else if (dx > 0.7) {
                ent2.getWorld().playSound(ent2.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                ent2.teleport(ent2.getLocation().add(0, 0, dx * 5));
            } else {
                ent2.getWorld().playSound(ent2.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                ent2.teleport(ent2.getLocation().add(dx * 5, 0, dx * 5));
            }
        }
        if (plugin.noShield && event.getEntity() instanceof Player) {
            Player eventPlayer = ((Player)event.getEntity());
            if (eventPlayer.isBlocking()) {
                event.setCancelled(true);
                eventPlayer.setCooldown(Material.SHIELD, 20 * 60);
            }
        }
    }

    @EventHandler
    public void onPortalCreated(PortalCreateEvent event) {
        if (event.getReason() == PortalCreateEvent.CreateReason.END_PLATFORM) {
            plugin.getServer().broadcastMessage(ChatColor.AQUA + "В энд портал зашёл человек.");
        }
    }

    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {
        var d = Math.random();
        if (d <= plugin.getConfig().getDouble("breedAdultChance")) {
            if (event.getEntity() instanceof Cow) ((Cow)event.getEntity()).setAdult();
            if (event.getEntity() instanceof Sheep) ((Sheep)event.getEntity()).setAdult();
            if (event.getEntity() instanceof Chicken) ((Chicken)event.getEntity()).setAdult();
            if (event.getEntity() instanceof Pig) ((Pig)event.getEntity()).setAdult();
            event.setExperience(24);
            event.getEntity().getWorld().playSound(event.getEntity().getLocation(), Sound.BLOCK_BELL_USE, 1f, 1f);
        }
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (plugin.spawnOnlySkeletons && event.getEntity().getType() != EntityType.SKELETON) {
            Entity entity = event.getEntity();
            World world = entity.getWorld();
            Location loc = entity.getLocation();
            event.setCancelled(true);
            world.spawnEntity(loc, EntityType.SKELETON);
        }
        if (plugin.spawnOnlySalmon && event.getEntity().getType() != EntityType.SALMON) {
            Entity entity = event.getEntity();
            World world = entity.getWorld();
            Location loc = entity.getLocation();
            event.setCancelled(true);
            world.spawnEntity(loc, EntityType.SALMON);
        }
    }

    @EventHandler
    public void onBlockBurned(BlockBurnEvent event) {
        Material blockMaterial = event.getBlock().getType();
        if (blockMaterial == Material.OAK_WOOD || blockMaterial == Material.OAK_PLANKS) {
            Block block = event.getBlock();
            block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.COAL, 1));
        }
    }

    @EventHandler
    public void onCauldronChangeLevel(CauldronLevelChangeEvent event) {
        if (event.getReason() == CauldronLevelChangeEvent.ChangeReason.NATURAL_FILL) event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {
        Material blockMaterial = event.getBlockPlaced().getType();
        if (blockMaterial == Material.GRAVEL) {
            event.getBlockPlaced().setType(Material.COBBLESTONE);
        }
        if (blockMaterial == Material.SUNFLOWER
                || blockMaterial == Material.CORNFLOWER
                || blockMaterial == Material.POPPY
                || blockMaterial == Material.DANDELION
                || blockMaterial == Material.OXEYE_DAISY
                || blockMaterial == Material.ORANGE_TULIP
                || blockMaterial == Material.PINK_TULIP
                || blockMaterial == Material.RED_TULIP
                || blockMaterial == Material.WHITE_TULIP
                || blockMaterial == Material.LILY_OF_THE_VALLEY
                || blockMaterial == Material.ALLIUM
                || blockMaterial == Material.BLUE_ORCHID
                || blockMaterial == Material.AZURE_BLUET) {
            event.getBlockPlaced().setType(Material.AIR);
            event.getPlayer().getWorld().dropItem(event.getBlockPlaced().getLocation(), new ItemStack(Material.WHEAT_SEEDS, 1));
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String nickname = event.getPlayer().getName();
        if (!plugin.isLexified.containsKey(nickname)) return;
        if (!plugin.isLexified.get(nickname)) return;
        event.setMessage(ChatColor.MAGIC + event.getMessage());
    }
}

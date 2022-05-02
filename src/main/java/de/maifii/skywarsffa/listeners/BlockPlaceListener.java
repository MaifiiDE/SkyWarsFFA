package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Location location = event.getBlockPlaced().getLocation();
        if (!SkyWarsFFA.getBuildMode().contains(player)) {
            if (location.getY() >= SkyWarsFFA.getInstance().getLocation().getDouble("spawnHeight.y")) {
                event.setCancelled(true);
            } else {
                    BlockFace face = event.getBlockPlaced().getFace(event.getBlockPlaced());
                    event.getBlockPlaced().setMetadata("Placed", new FixedMetadataValue(SkyWarsFFA.getInstance(), face));
                    if (event.getBlockReplacedState().hasMetadata("Break")) {
                        return;
                    }
                    Bukkit.getScheduler().runTaskLater(SkyWarsFFA.getInstance(), () -> {
                        event.getBlockPlaced().breakNaturally(new ItemStack(Material.AIR));

                        location.getWorld().playEffect(location, Effect.ENDER_SIGNAL, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON, 1F, 1F);
                    }, 20*3);
                }
            }
        }
    }
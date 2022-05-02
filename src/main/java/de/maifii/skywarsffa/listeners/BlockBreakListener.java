package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;


public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {


        Player player = event.getPlayer();
        Location location = event.getBlock().getLocation();
        if (!SkyWarsFFA.getBuildMode().contains(player)) {
            if (location.getY() >= SkyWarsFFA.getInstance().getLocation().getDouble("spawnHeight.y")) {
                event.setCancelled(true);
            } else {
                final Material blockType = event.getBlock().getType();
                final BlockData blockdata = event.getBlock().getBlockData();
                BlockFace face = event.getBlock().getFace(event.getBlock());
                event.getBlock().setMetadata("Break", new FixedMetadataValue(Objects.requireNonNull(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("SkyWarsFFA"))), face));
                if (event.getBlock().hasMetadata("Placed")) {
                    return;
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> {
                    event.getBlock().setType(blockType);
                    event.getBlock().setBlockData(blockdata);

                    location.getWorld().playEffect(location, Effect.ENDER_SIGNAL, 3);
                    location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON, 1F, 1F);
                }, 20 * 3);
            }
        }
    }
}
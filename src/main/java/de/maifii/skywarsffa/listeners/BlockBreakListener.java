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
import org.bukkit.metadata.MetadataValue;


public class BlockBreakListener implements Listener {

    /* TODO: -Ausnahme beim Abbau bei einer Kiste machen
             -
    *
    * */


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {


        Player spieler = event.getPlayer();
        Location location = event.getBlock().getLocation();
        if (!SkyWarsFFA.getBuildMode().contains(spieler)) {
            if (location.getY() >= SkyWarsFFA.getInstance().getLocation().getDouble("Spawnheight.Y")) {
                event.setCancelled(true);
            } else {
                Player p = event.getPlayer();


                final Material blocktype = event.getBlock().getType();
                final BlockData blockdata = event.getBlock().getBlockData();
                BlockFace face = event.getBlock().getFace(event.getBlock());
                event.getBlock().setMetadata("Break", (MetadataValue) new FixedMetadataValue(Bukkit.getPluginManager().getPlugin("SkyWarsFFA"), (Object) face));
                if (event.getBlock().hasMetadata("Placed")) {
                    return;
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {

                    int blocktime = 4;

                    @Override
                    public void run() {
                        event.getBlock().setType(blocktype);
                        event.getBlock().setBlockData(blockdata);

                        location.getWorld().playEffect(location, Effect.ENDER_SIGNAL, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON, 1F, 1F);
                    }
                }, 20 * 3);
            }
        }
    }
}
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
import org.bukkit.metadata.MetadataValue;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player spieler = event.getPlayer();
        //LOCATION FÜR PLAZIERTEN BLOCK ERSTELLEN
        Location location = event.getBlockPlaced().getLocation();
        //WENN SPIELER NICHT IN BUILDMODE IST
        if (!SkyWarsFFA.getBuildMode().contains(spieler)) {
            //WENN DIE BLOCK LOCATION GRÖßER ODER GLEICH IST WIE SPAWNHEIGHT
            if (location.getY() >= SkyWarsFFA.getInstance().getLocation().getDouble("Spawnheight.Y")) {
                event.setCancelled(true);
                //WENN SPIELER BEDINGUNG ERFÜLLT
            } else {
                    BlockFace face = event.getBlockPlaced().getFace(event.getBlockPlaced());
                    event.getBlockPlaced().setMetadata("Placed", (MetadataValue) new FixedMetadataValue(SkyWarsFFA.getInstance(), (Object) face));
                    if (event.getBlockReplacedState().hasMetadata("Break")) {
                        return;
                    }
                    Bukkit.getScheduler().runTaskLater(SkyWarsFFA.getInstance(), new Runnable() {

                        @Override
                        public void run() {
                            event.getBlockPlaced().breakNaturally(new ItemStack(Material.AIR));

                            location.getWorld().playEffect(location, Effect.ENDER_SIGNAL, 3);
                            location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON, 1F, 1F);
                        }
                    }, 20*3);
                }
            }
        }
    }
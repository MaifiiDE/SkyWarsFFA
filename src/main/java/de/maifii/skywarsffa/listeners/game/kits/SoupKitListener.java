package de.maifii.skywarsffa.listeners.game.kits;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SoupKitListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(SkyWarsFFA.getPlayersInSoupKit().contains(event.getPlayer())) {
            Player player = event.getPlayer();
            try {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    double i = player.getHealth();
                    ItemStack bowl = new ItemStack(Material.BOWL);
                    if (event.getItem().getType() == Material.MUSHROOM_STEW) {
                        if (i > 11.0) {
                            player.setFoodLevel((int) 20.0);
                            player.setHealth(20.0);
                            player.getInventory().setItemInHand(bowl);
                        } else {
                            player.setFoodLevel((int) (i + 8.0));
                            player.setHealth(i + 8.0);
                            player.getInventory().setItemInMainHand(bowl);
                        }
                    }
                }
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
        }
        else {
        }
    }
}

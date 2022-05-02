package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Entity playerEntity = event.getEntity();
        Player player = null;
        if (playerEntity instanceof Player) {
            player = (Player) ((Object)playerEntity);
        }
        if (player instanceof Player) {
            if (player.getLocation().getY() >= SkyWarsFFA.getInstance().getLocation().getDouble("Spawnheight.Y")) {
                event.setCancelled(true);
            }
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }
        }
    }
}


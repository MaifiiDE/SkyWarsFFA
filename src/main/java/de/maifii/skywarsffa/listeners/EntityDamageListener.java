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
        Player spieler = null;
        if (playerEntity instanceof Player) {
            spieler = (Player) ((Object)playerEntity);
        }
        if (spieler instanceof Player) {
            if (spieler.getLocation().getY() >= SkyWarsFFA.getInstance().getLocation().getDouble("Spawnheight.Y")) {
                event.setCancelled(true);
            }
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }
        }
    }
}


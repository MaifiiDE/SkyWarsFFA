package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.InventoryUtils;
import de.maifii.skywarsffa.utils.ItemUtils;
import de.maifii.skywarsffa.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        LocationUtils locations = new LocationUtils();
        ItemUtils items = new ItemUtils();
        InventoryUtils invs = new InventoryUtils();

        Entity playerEntity = event.getEntity();
        Entity damagerEntity = event.getDamager();
        Player spieler = null;
        Player lastdamager = null;

        if (playerEntity instanceof Player) {
            spieler = (Player)((Object)playerEntity);
        }
        if (damagerEntity instanceof Player) {
            lastdamager = (Player)((Object)damagerEntity);
        }

        if(spieler.getLocation().getY() <= SkyWarsFFA.getInstance().getLocation().getDouble("Spawnheight.Y")) {
            SkyWarsFFA.getInstance().getLastDamager().put(spieler, lastdamager);
            if (spieler.getHealth() - event.getFinalDamage() <= 0.0) {
                event.setCancelled(true);
                Bukkit.broadcastMessage(SkyWarsFFA.Prefix + "Der Spieler §9" + spieler.getName() + " §7wurde von §9" + lastdamager.getName() + " §7getötet.");
                locations.teleport("Spawn", spieler);
                spieler.setHealth(20);
                spieler.getInventory().clear();
                invs.setEquipment(spieler);
                invs.setInventory(spieler);
                invs.addEnderPearl(lastdamager);

                lastdamager.setHealth(20);
                lastdamager.getWorld().playSound(spieler.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20.0f, 0.5f);
            }
        }else {
            event.setCancelled(true);
        }


    }
}

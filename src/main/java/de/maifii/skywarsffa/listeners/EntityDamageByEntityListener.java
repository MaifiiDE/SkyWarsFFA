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
        InventoryUtils invUtils = new InventoryUtils();

        Entity playerEntity = event.getEntity();
        Entity damagerEntity = event.getDamager();
        Player player = null;
        Player lastDamager = null;

        if (playerEntity instanceof Player) {
            player = (Player)((Object)playerEntity);
        }
        if (damagerEntity instanceof Player) {
            lastDamager = (Player)((Object)damagerEntity);
        }

        if(player.getLocation().getY() <= SkyWarsFFA.getInstance().getLocation().getDouble("Spawnheight.Y")) {
            SkyWarsFFA.getInstance().getLastDamager().put(player, lastDamager);
            if (player.getHealth() - event.getFinalDamage() <= 0.0) {
                event.setCancelled(true);
                Bukkit.broadcastMessage(SkyWarsFFA.Prefix + "Der Spieler §9" + player.getName() + " §7wurde von §9" + lastDamager.getName() + " §7getötet.");
                locations.teleport("Spawn", player);
                player.setHealth(20);
                player.getInventory().clear();
                invUtils.setEquipment(player);
                invUtils.setInventory(player);
                invUtils.addEnderPearl(lastDamager);

                lastDamager.setHealth(20);
                lastDamager.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20.0f, 0.5f);
            }
        }else {
            event.setCancelled(true);
        }


    }
}

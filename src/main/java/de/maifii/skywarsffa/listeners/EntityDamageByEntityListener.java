package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.InventoryUtils;
import de.maifii.skywarsffa.utils.LocationUtils;
import de.maifii.skywarsffa.utils.MessageUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        InventoryUtils invUtils = new InventoryUtils();

        if (!(event.getEntity() instanceof Player player && event.getDamager() instanceof Player lastDamager)) {
            event.setCancelled(true);
            return;
        }

        if(player.getLocation().getY() <= SkyWarsFFA.getLocationUtils().getSpawnHeight()) {
            SkyWarsFFA.getInstance().getLastDamager().put(player, lastDamager);
            if (player.getHealth() - event.getFinalDamage() <= 0.0) {

                Bukkit.getServer().broadcast(Component.text(MessageUtils.messages.prefix + "Der Spieler §9" + player.getName() + " §7wurde von §9" + lastDamager.getName() + " §7getötet."));
                LocationUtils.get().teleport("spawn", player);
                player.setHealth(20);
                player.getInventory().clear();
                invUtils.setDefaultEquipment(player);
                invUtils.setDefaultInventory(player);
                invUtils.addEnderPearl(lastDamager);

                lastDamager.setHealth(20);
                lastDamager.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20.0f, 0.5f);
            }
        }else {
            event.setCancelled(true);
        }


    }
}

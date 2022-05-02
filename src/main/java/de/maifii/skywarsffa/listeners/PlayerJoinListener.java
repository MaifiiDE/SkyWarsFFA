package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.InventoryUtils;
import de.maifii.skywarsffa.utils.LocationUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        LocationUtils locations = new LocationUtils();
        InventoryUtils invUtils = new InventoryUtils();
        Player player = event.getPlayer();

        player.setMaxHealth(20.0);
        player.setHealth(20.0);
        invUtils.setInventory(player);
        invUtils.setEquipment(player);
        event.setJoinMessage(SkyWarsFFA.Prefix + "Der Spieler §9" + player.getName() + " §7hat das Spiel betreten.");
        locations.teleport("Spawn", player);
    }
}

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
        InventoryUtils invs = new InventoryUtils();
        Player spieler = event.getPlayer();

        spieler.setMaxHealth(20.0);
        spieler.setHealth(20.0);
        invs.setInventory(spieler);
        invs.setEquipment(spieler);
        event.setJoinMessage(SkyWarsFFA.Prefix + "Der Spieler §9" + spieler.getName() + " §7hat das Spiel betreten.");
        locations.teleport("Spawn", spieler);
    }
}

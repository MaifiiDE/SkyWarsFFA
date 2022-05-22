package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.InventoryUtils;
import de.maifii.skywarsffa.utils.ItemUtils;
import de.maifii.skywarsffa.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        LocationUtils locations = new LocationUtils();
        ItemUtils items = new ItemUtils();
        InventoryUtils invs = new InventoryUtils();

        Player spieler = event.getPlayer();
        Player lastDamager = SkyWarsFFA.getInstance().getLastDamager().get(spieler);

        if (spieler.getLocation().getY() <= SkyWarsFFA.getInstance().getLocation().getDouble("Deathheight.Y")) {
            if (lastDamager != null) {
                Bukkit.broadcastMessage(SkyWarsFFA.Prefix + "Der Spieler §9" + spieler.getName() + " §7wurde von §9"+ lastDamager.getName()+ " §7getötet.");
                locations.teleport("Spawn", spieler);
                spieler.setHealth(20.0);
                spieler.getInventory().clear();
                invs.setKitInv(spieler);
                invs.addEnderPearl(lastDamager);
                lastDamager.setHealth(20.0);
                lastDamager.playSound(spieler.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20.0f, 0.5f);
            } else {
                locations.teleport("Spawn", spieler);
                spieler.setHealth(20.0);
                spieler.getInventory().clear();
                invs.setKitInv(spieler);
                Bukkit.broadcastMessage(SkyWarsFFA.Prefix + "Der Spieler §9" + spieler.getName() + " §7ist gestorben.");
            }
        }
    }
}


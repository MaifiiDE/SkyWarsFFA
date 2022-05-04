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
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        InventoryUtils invUtils = new InventoryUtils();

        Player player = event.getPlayer();
        Player lastDamager = SkyWarsFFA.getInstance().getLastDamager().get(player);

        if (player.getLocation().getY() <= SkyWarsFFA.getInstance().getLocation().getDouble("deathHeight.y")) {
            if (lastDamager != null) {
                Bukkit.getServer().broadcast(Component.text(MessageUtils.messages.prefix + "Der Spieler §9" + player.getName() + " §7wurde von §9"+ lastDamager.getName()+ " §7getötet."));
                LocationUtils.teleport("Spawn", player);
                player.setHealth(20.0);
                player.getInventory().clear();
                invUtils.setDefaultInventory(player);
                invUtils.setDefaultEquipment(player);
                invUtils.addEnderPearl(lastDamager);
                lastDamager.setHealth(20.0);
                lastDamager.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20.0f, 0.5f);
            } else {
                LocationUtils.teleport("Spawn", player);
                player.setHealth(20.0);
                player.getInventory().clear();
                invUtils.setDefaultInventory(player);
                invUtils.setDefaultEquipment(player);
                Bukkit.getServer().broadcast(Component.text(MessageUtils.messages.prefix + "Der Spieler §9" + player.getName() + " §7ist gestorben."));
            }
        }
    }
}


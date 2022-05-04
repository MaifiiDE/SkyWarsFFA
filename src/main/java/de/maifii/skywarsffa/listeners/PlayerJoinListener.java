package de.maifii.skywarsffa.listeners;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.InventoryUtils;
import de.maifii.skywarsffa.utils.LocationUtils;
import de.maifii.skywarsffa.utils.MessageUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        InventoryUtils invUtils = new InventoryUtils();
        Player player = event.getPlayer();

        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(20.0);
        player.setHealth(20.0);
        invUtils.setDefaultInventory(player);
        invUtils.setDefaultEquipment(player);
        event.joinMessage(Component.text(MessageUtils.messages.prefix + "Der Spieler §9" + player.getName() + " §7hat das Spiel betreten."));
        LocationUtils.teleport("Spawn", player);
    }
}

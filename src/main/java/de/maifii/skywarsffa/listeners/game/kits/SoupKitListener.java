package de.maifii.skywarsffa.listeners.game.kits;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoupKitListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(SkyWarsFFA.getSoupKit().contains(event.getPlayer())) {
            
        }
        return;
    }

}

package de.maifii.skywarsffa.listeners.game;


import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.InventoryUtils;
import de.maifii.skywarsffa.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class KitInvListener implements Listener {

    final String KIT_GUI_NAME = "§5Kit-Inventar";
    public static String KitItem = "§5Kit-Inventar";

    final InventoryUtils inventoryUtils = new InventoryUtils();

    /* TODO: -
             -
    *
    *
    * */

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.getInventory().clear();
        player.setMaxHealth(20.0);
        player.setHealth(20.0);
        inventoryUtils.setKitInv(player);
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() == null || event.getItem().getItemMeta() == null) return;
        if (!(event.getItem().getItemMeta().getDisplayName().equals(KitItem))) return;

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            openKitInv(event.getPlayer());
        }
    }


    public void openKitInv(Player player) {
        Inventory kits = Bukkit.createInventory(null, 54, KIT_GUI_NAME);

        ItemUtils.setItemInInventory(kits, Material.IRON_BOOTS, "§5Stomper-Kit", 31, 1);
        ItemUtils.setItemInInventory(kits, Material.MUSHROOM_STEW, "§5Soup-Kit", 22, 1);

        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 9, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 0, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 1, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 2, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 6, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 7, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 8, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 17, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 36, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 45, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 46, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 47, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 51, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 52, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 53, 1);
        ItemUtils.setItemInInventory(kits, Material.BARRIER, " ", 44, 1);

        player.openInventory(kits);
    }


    @EventHandler
    public void OnKITGUIClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player spieler = (Player) event.getWhoClicked();
        if (!event.getView().getTitle().equals(KIT_GUI_NAME)) return;
        event.setCancelled(true);
        if (event.getCurrentItem() == null) return;
        switch (event.getCurrentItem().getType()) {
            case MUSHROOM_STEW: {
                if (!SkyWarsFFA.getPlayersInSoupKit().contains(spieler)) {
                    SkyWarsFFA.getPlayersInSoupKit().add((Player) event.getWhoClicked());
                    spieler.sendMessage(SkyWarsFFA.Prefix + "Du hast das Kit §5Soup §7ausgewählt.");
                    spieler.playSound(spieler.getLocation(), Sound.BLOCK_TRIPWIRE_CLICK_ON, 1, 1);
                    spieler.closeInventory();
                    spieler.getInventory().clear();
                    inventoryUtils.setSoupKit(spieler);
                } else {
                    spieler.sendMessage(SkyWarsFFA.Prefix + "Du hast dieses Kit bereits ausgewählt.");
                    spieler.playSound(spieler.getLocation(), Sound.BLOCK_TRIPWIRE_CLICK_ON, 1, 1);
                    spieler.closeInventory();
                }
            }
            break;
        }
    }
}

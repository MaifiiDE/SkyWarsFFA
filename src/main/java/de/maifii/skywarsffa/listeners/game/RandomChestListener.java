package de.maifii.skywarsffa.listeners.game;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.ItemUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomChestListener implements Listener {

    @EventHandler
    public void onRandomChestClick(PlayerInteractEvent event) {

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();

            if(Objects.requireNonNull(block).getType() == Material.CHEST) {

                Location location = event.getClickedBlock().getLocation();
                ItemUtils items = new ItemUtils();
                Player player = event.getPlayer();

                player.closeInventory();
                player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1f ,1f);
                player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1f);
                player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1f);
                Objects.requireNonNull(block).setType(Material.GLASS);
                location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON, 1, 1);
                Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20 * 120);

                switch (ThreadLocalRandom.current().nextInt(19)) {
                    case 0 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.EGG, "§9Eier", 5);
                    case 1 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.COOKED_BEEF, "§9Fleisch", 8);
                    case 2 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.BEETROOT_SOUP, "§9Suppe", 6);
                    case 3 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.BOW, "§9Bogen", 1);
                    case 4 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.ARROW, "§9Pfeile", 10);
                    case 5 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_SWORD, "§9Eisen Schwert", 1);
                    case 6 -> items.setItemInInventoryWithEnchantment(event.getPlayer().getInventory(), Material.IRON_SWORD, "§9Eisen Schwert", Enchantment.DAMAGE_ALL, 1, 1);
                    case 7 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.FISHING_ROD, "§9Angel", 1);
                    case 8 -> items.setItemInInventoryWithEnchantment(event.getPlayer().getInventory(), Material.FISHING_ROD, "§9Angel", Enchantment.DURABILITY, 3, 1);
                    case 9 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_CHESTPLATE, "§9Eisen Brustpanzer", 1);
                    case 10 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_LEGGINGS, "§9Eisen Hose", 1);
                    case 11 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_BOOTS, "§9Eisen Schuhe", 1);
                    case 12 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_HELMET, "§9Eisen Helm", 1);
                    case 13 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.GOLDEN_APPLE, "§9Goldapfel", 1);
                    case 14 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_CHESTPLATE, "§9Diamant Brustpanzer", 1);
                    case 15 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_LEGGINGS, "§9Diament Hose", 1);
                    case 16 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_BOOTS, "§9Diamant Schuhe", 1);
                    case 17 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_HELMET, "§9Diamant Helm", 1);
                    case 18 -> items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_SWORD, "§9Diamant Schwert", 1);
                }
            }
        }
    }
}

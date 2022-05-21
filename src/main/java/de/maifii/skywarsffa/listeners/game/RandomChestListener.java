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

public class RandomChestListener implements Listener {

    @EventHandler
    public void onRandomChestClick(PlayerInteractEvent event) {


        ItemUtils items = new ItemUtils();
        Player player = event.getPlayer();




        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();

            if(event.getClickedBlock().getType() == Material.CHEST) {
                Random r = new Random();
                int zufall = r.nextInt(19);
                switch (zufall) {
                    case 0:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.EGG, "§9Eier", 5);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 1:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.COOKED_BEEF, "§9Fleisch", 8);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 2:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.BEETROOT_SOUP, "§9Suppe", 6);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 3:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.BOW, "§9Bogen", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 4:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.ARROW, "§9Pfeile", 10);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 5:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_SWORD, "§9Eisen Schwert", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 6:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.setItemInInventoryWithEnchantment(event.getPlayer().getInventory(), Material.IRON_SWORD, "§9Eisen Schwert", Enchantment.DAMAGE_ALL, 1, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 7:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.FISHING_ROD, "§9Angel", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 8:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.setItemInInventoryWithEnchantment(event.getPlayer().getInventory(), Material.FISHING_ROD, "§9Angel", Enchantment.DURABILITY, 3, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 9:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_CHESTPLATE, "§9Eisen Brustpanzer", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 10:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_LEGGINGS, "§9Eisen Hose", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 11:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_BOOTS, "§9Eisen Schuhe", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 12:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_HELMET, "§9Eisen Helm", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 13:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.GOLDEN_APPLE, "§9Goldapfel", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 14:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_CHESTPLATE, "§9Diamant Brustpanzer", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 15:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_LEGGINGS, "§9Diament Hose", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 16:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_BOOTS, "§9Diamant Schuhe", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 17:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);
                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_HELMET, "§9Diamant Helm", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                    case 18:
                        player.closeInventory();
                        player.playSound(block.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F ,1F);
                        player.playEffect(block.getLocation(), Effect.BLAZE_SHOOT, 1);
                        player.playEffect(block.getLocation(), Effect.ELECTRIC_SPARK, 1);

                        block.setType(Material.GLASS);

                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_SWORD, "§9Diamant Schwert", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), () -> block.setType(Material.CHEST), 20*120);
                        break;
                }
            }
        }
    }
}

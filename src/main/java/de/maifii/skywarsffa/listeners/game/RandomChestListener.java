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

import java.util.Random;

public class RandomChestListener implements Listener {

    @EventHandler
    public void onRandomChestClick(PlayerInteractEvent event) {

        Location location = event.getClickedBlock().getLocation();
        ItemUtils items = new ItemUtils();
        Player spieler = event.getPlayer();




        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();

            if(event.getClickedBlock().getType() == Material.CHEST) {
                Random r = new Random();
                int zufall = r.nextInt(19);
                switch (zufall) {
                    case 0:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.EGG, "§9Eier", 5);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 1:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.COOKED_BEEF, "§9Fleisch", 8);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 2:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.BEETROOT_SOUP, "§9Suppe", 6);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 3:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.BOW, "§9Bogen", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 4:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.ARROW, "§9Pfeile", 10);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 5:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_SWORD, "§9Eisen Schwert", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 6:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.setItemInInventoryWithEnchantment(event.getPlayer().getInventory(), Material.IRON_SWORD, "§9Eisen Schwert", Enchantment.DAMAGE_ALL, 1, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 7:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.FISHING_ROD, "§9Angel", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 8:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.setItemInInventoryWithEnchantment(event.getPlayer().getInventory(), Material.FISHING_ROD, "§9Angel", Enchantment.DURABILITY, 3, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 9:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_CHESTPLATE, "§9Eisen Brustpanzer", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 10:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_LEGGINGS, "§9Eisen Hose", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 11:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_BOOTS, "§9Eisen Schuhe", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 12:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.IRON_HELMET, "§9Eisen Helm", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 13:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.GOLDEN_APPLE, "§9Goldapfel", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 14:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_CHESTPLATE, "§9Diamant Brustpanzer", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 15:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_LEGGINGS, "§9Diament Hose", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 16:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_BOOTS, "§9Diamant Schuhe", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 17:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_HELMET, "§9Diamant Helm", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                    case 18:
                        spieler.closeInventory();
                        block.setType(Material.GLASS);
                        location.getWorld().playEffect(location, Effect.SMOKE, 3, 3);
                        location.getWorld().playSound(location, Sound.BLOCK_TRIPWIRE_CLICK_ON,1, 1);
                        items.addItemInInventory(event.getPlayer().getInventory(), Material.DIAMOND_SWORD, "§9Diamant Schwert", 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SkyWarsFFA.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.CHEST);
                            }
                        }, 20*120);
                        break;
                }
            }
        }
    }
}

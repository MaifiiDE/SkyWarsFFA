package de.maifii.skywarsffa.utils;

import de.maifii.skywarsffa.listeners.game.KitInvListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryUtils {

    /* *
    * TODO: -create methods to set special Kit inventorys
    *       -
    *
    *
    *
    * */

    public void setEquipment(Player spieler) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();
        helmetMeta.setUnbreakable(true);
        helmet.setItemMeta(helmetMeta);
        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        chestplateMeta.setUnbreakable(true);
        chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestplate.setItemMeta(chestplateMeta);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingsMeta = leggings.getItemMeta();
        leggingsMeta.setUnbreakable(true);
        leggings.setItemMeta(leggingsMeta);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        spieler.getEquipment().setHelmet(helmet);
        spieler.getEquipment().setChestplate(chestplate);
        spieler.getEquipment().setLeggings(leggings);
        spieler.getEquipment().setBoots(boots);
    }

    public void setDefaultInv(Player player) {
        ItemUtils items = new ItemUtils();
        items.setItemInInventoryWithEnchantment(player.getInventory(), Material.STONE_SWORD, "", Enchantment.DAMAGE_ALL, 1, 0);
        items.setItemInInventory(player.getInventory(), Material.STONE_PICKAXE, "", 1, 1);
        items.setItemInInventory(player.getInventory(), Material.STONE_AXE, "", 2, 1);
    }

    public void setKitInv(Player player) {
        ItemUtils items = new ItemUtils();
        items.setItemInInventory(player.getInventory(), Material.CHEST, KitInvListener.KitItem, 4, 1);
    }

    public void addEnderPearl(Player player) {
        ItemUtils items = new ItemUtils();
        items.addItemInInventory(player.getInventory(), Material.ENDER_PEARL, "", 1);
    }





    public void setSoupKit(Player player) {
        ItemUtils items = new ItemUtils();
        setDefaultInv(player);
        items.setItemInInventory(player.getInventory(), Material.BOWL, "", 6, 64);
        items.setItemInInventory(player.getInventory(), Material.RED_MUSHROOM, "", 7, 64);
        items.setItemInInventory(player.getInventory(), Material.BROWN_MUSHROOM, "", 8, 64);
    }

}

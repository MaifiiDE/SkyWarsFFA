package de.maifii.skywarsffa.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryUtils {

    public void setDefaultEquipment(Player player) {
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
        player.getEquipment().setHelmet(helmet);
        player.getEquipment().setChestplate(chestplate);
        player.getEquipment().setLeggings(leggings);
        player.getEquipment().setBoots(boots);
    }

    public void setDefaultInventory(Player player) {
        ItemUtils items = new ItemUtils();
        items.setItemInInventoryWithEnchantment(player.getInventory(), Material.IRON_SWORD, "", Enchantment.DAMAGE_ALL, 1, 0);
        items.setItemInInventoryWithEnchantment(player.getInventory(), Material.STICK, "", Enchantment.KNOCKBACK, 1, 1);
        items.setItemInInventory(player.getInventory(), Material.ENDER_PEARL, "", 2, 2);
        items.setItemInInventory(player.getInventory(), Material.SANDSTONE, "", 3, 64);
        items.setItemInInventory(player.getInventory(), Material.SANDSTONE, "", 4, 64);
        items.setItemInInventory(player.getInventory(), Material.SANDSTONE, "", 5, 64);
        items.setItemInInventory(player.getInventory(), Material.SANDSTONE, "", 6, 64);
        items.setItemInInventory(player.getInventory(), Material.SANDSTONE, "", 7, 64);
        items.setItemInInventory(player.getInventory(), Material.LADDER, "", 8, 4);
    }

    public void addEnderPearl(Player player) {
        ItemUtils items = new ItemUtils();
        items.addItemInInventory(player.getInventory(), Material.ENDER_PEARL, "", 1);
    }

}

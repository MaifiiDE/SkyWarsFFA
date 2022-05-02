package de.maifii.skywarsffa.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    public void setItemInInventory(Inventory inventory, Material material, String displayName, Integer slot, Integer amount) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text(displayName));
        item.setItemMeta(itemMeta);
        item.setAmount(amount);
        inventory.setItem(slot, item);
    }

    public void addItemInInventory(Inventory inventory, Material material, String displayName, Integer amount) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text(displayName));
        itemMeta.setUnbreakable(true);
        item.setItemMeta(itemMeta);
        item.setAmount(amount);
        inventory.addItem(item);
    }

    public void setItemInInventoryWithEnchantment(Inventory inventory, Material material, String displayName, Enchantment enchantment, Integer enchantmentValue, Integer slot) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text(displayName));
        itemMeta.addEnchant(enchantment, enchantmentValue, true);
        itemMeta.setUnbreakable(true);
        item.setItemMeta(itemMeta);
        inventory.setItem(slot, item);
    }
}

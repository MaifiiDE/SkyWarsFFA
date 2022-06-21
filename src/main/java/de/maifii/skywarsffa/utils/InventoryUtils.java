package de.maifii.skywarsffa.utils;

import de.maifii.skywarsffa.listeners.game.KitInvListener;
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
        assert helmetMeta != null;
        helmetMeta.setUnbreakable(true);
        helmet.setItemMeta(helmetMeta);
        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        assert chestplateMeta != null;
        chestplateMeta.setUnbreakable(true);
        chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestplate.setItemMeta(chestplateMeta);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingsMeta = leggings.getItemMeta();
        assert leggingsMeta != null;
        leggingsMeta.setUnbreakable(true);
        leggings.setItemMeta(leggingsMeta);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        assert bootsMeta != null;
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        if(spieler.getEquipment() == null) return;
        spieler.getEquipment().setHelmet(helmet);
        spieler.getEquipment().setChestplate(chestplate);
        spieler.getEquipment().setLeggings(leggings);
        spieler.getEquipment().setBoots(boots);
    }

    public void setDefaultInv(Player player) {
        ItemUtils.setItemInInventoryWithEnchantment(player.getInventory(), Material.STONE_SWORD, "", Enchantment.DAMAGE_ALL, 1, 0);
        ItemUtils.setItemInInventory(player.getInventory(), Material.STONE_PICKAXE, "", 1, 1);
        ItemUtils.setItemInInventory(player.getInventory(), Material.STONE_AXE, "", 2, 1);
    }

    public void setKitInv(Player player) {
        ItemUtils.setItemInInventory(player.getInventory(), Material.CHEST, KitInvListener.KitItem, 4, 1);
    }

    public void addEnderPearl(Player player) {
        ItemUtils.addItemInInventory(player.getInventory(), Material.ENDER_PEARL, "", 1);
    }


    public void setSoupKit(Player player) {
        setDefaultInv(player);
        ItemUtils.setItemInInventory(player.getInventory(), Material.BOWL, "", 6, 64);
        ItemUtils.setItemInInventory(player.getInventory(), Material.RED_MUSHROOM, "", 7, 64);
        ItemUtils.setItemInInventory(player.getInventory(), Material.BROWN_MUSHROOM, "", 8, 64);
    }

}

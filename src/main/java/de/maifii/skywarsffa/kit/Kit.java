package de.maifii.skywarsffa.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public interface Kit extends Listener {

    String getId();

    String getDisplayName();

    ItemStack getDisplayItem();

    void setDefaultEquipment(Player player);

    void setDefaultInventory(Player player);

}

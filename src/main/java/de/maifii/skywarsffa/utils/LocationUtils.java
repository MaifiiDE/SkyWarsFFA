package de.maifii.skywarsffa.utils;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.IOException;

public class LocationUtils {

    public void teleport(String name, Player spieler) {
        String worldName = SkyWarsFFA.getInstance().getLocation().getString(name + ".World");
        World world = (worldName == null) ? null : Bukkit.getWorld(worldName);
        if (world == null) return;
        double x = SkyWarsFFA.getInstance().getLocation().getDouble(name + ".X");
        double y = SkyWarsFFA.getInstance().getLocation().getDouble(name + ".Y");
        double z = SkyWarsFFA.getInstance().getLocation().getDouble(name + ".Z");
        float yaw = (float) SkyWarsFFA.getInstance().getLocation().getDouble(name + ".Yaw");
        float pitch = (float) SkyWarsFFA.getInstance().getLocation().getDouble(name + ".Pitch");
        Location location = new Location(world, x, y, z, yaw, pitch);
        spieler.teleport(location);
    }

    //LOCATIONS
    public void setLocation(String name, Player spieler) {
        SkyWarsFFA.getInstance().getLocation().set(name + ".World", spieler.getWorld().getName());
        SkyWarsFFA.getInstance().getLocation().set(name + ".X", spieler.getLocation().getX());
        SkyWarsFFA.getInstance().getLocation().set(name + ".Y", spieler.getLocation().getY());
        SkyWarsFFA.getInstance().getLocation().set(name + ".Z", spieler.getLocation().getZ());
        SkyWarsFFA.getInstance().getLocation().set(name + ".Yaw", spieler.getLocation().getYaw());
        SkyWarsFFA.getInstance().getLocation().set(name + ".Pitch", spieler.getLocation().getPitch());
        try {
            SkyWarsFFA.getInstance().getLocation().save(SkyWarsFFA.getInstance().getFile());
            spieler.sendMessage(SkyWarsFFA.Prefix + "DU hast die Location §e" + name + " §7gesetzt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //HÖHEN
    public void setHeight(String name, Player spieler) {
        SkyWarsFFA.getInstance().getLocation().set(name + ".Y", spieler.getLocation().getY());
        try {
            SkyWarsFFA.getInstance().getLocation().save(SkyWarsFFA.getInstance().getFile());
            spieler.sendMessage(SkyWarsFFA.Prefix + "Du hast die Location §e" + name + "§7 gesetzt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

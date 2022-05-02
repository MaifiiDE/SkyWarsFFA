package de.maifii.skywarsffa.utils;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Objects;

public class LocationUtils {

    public static void teleport(String name, Player player) {
        World world = Bukkit.getWorld(Objects.requireNonNull(SkyWarsFFA.getInstance().getLocation().getString(name + ".world")));
        double x = SkyWarsFFA.getInstance().getLocation().getDouble(name + ".x");
        double y = SkyWarsFFA.getInstance().getLocation().getDouble(name + ".y");
        double z = SkyWarsFFA.getInstance().getLocation().getDouble(name + ".z");
        float yaw = (float) SkyWarsFFA.getInstance().getLocation().getDouble(name + ".yaw");
        float pitch = (float) SkyWarsFFA.getInstance().getLocation().getDouble(name + ".pitch");
        Location location = new Location(world, x, y, z, yaw, pitch);
        player.teleport(location);
    }

    public static void setLocation(String name, Player player) {
        SkyWarsFFA.getInstance().getLocation().set(name + ".world", player.getWorld().getName());
        SkyWarsFFA.getInstance().getLocation().set(name + ".x", player.getLocation().getX());
        SkyWarsFFA.getInstance().getLocation().set(name + ".y",player.getLocation().getY());
        SkyWarsFFA.getInstance().getLocation().set(name + ".z", player.getLocation().getZ());
        SkyWarsFFA.getInstance().getLocation().set(name + ".yaw", player.getLocation().getYaw());
        SkyWarsFFA.getInstance().getLocation().set(name + ".pitch", player.getLocation().getPitch());
        try {
            SkyWarsFFA.getInstance().getLocation().save(SkyWarsFFA.getInstance().getFile());
            player.sendMessage(SkyWarsFFA.prefix + "Du hast die Location §e" + name + " §7gesetzt.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setHeight(String name, Player player) {
        SkyWarsFFA.getInstance().getLocation().set(name + ".y", player.getLocation().getY());
        try {
            SkyWarsFFA.getInstance().getLocation().save(SkyWarsFFA.getInstance().getFile());
            player.sendMessage(SkyWarsFFA.prefix + "Du hast die Location §e" +  name + "§7 gesetzt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package de.maifii.skywarsffa.utils;

import de.maifii.skywarsffa.SkyWarsFFA;
import me.wawwior.config.ConfigProvider;
import me.wawwior.config.Configurable;
import me.wawwior.config.IConfig;
import me.wawwior.config.io.impl.FileInfo;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LocationUtils extends Configurable<LocationUtils.LocationConfig, FileInfo> {

    public LocationUtils(ConfigProvider<FileInfo> provider) {
        super(LocationConfig.class, FileInfo.of("/", "locations"), provider);
    }

    public static class LocationConfig implements IConfig {

        public Map<String, Location> anchors = new HashMap<>();

        public double spawnHeight;

        public double deathHeight;


    }

    public void teleport(String name, Player player) {
        player.teleport(config.anchors.get(name));
    }

    public void setLocation(String name, Player player) {
        config.anchors.replace(name, player.getLocation());
    }

    public void setHeight(String name, Player player) {
        try {
            config.anchors.get(name).setY(player.getLocation().getY());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public double getSpawnHeight() {
        return config.spawnHeight;
    }

    public double getDeathHeight() {
        return config.deathHeight;
    }

    public static LocationUtils get() {
        return SkyWarsFFA.getLocationUtils();
    }
}

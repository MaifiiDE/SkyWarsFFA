package de.maifii.skywarsffa.utils;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileUtils {

    public static File getConfigFile() {
        return new File("plugins/SkyWarsFFA", "config.yml");
    }

    public static FileConfiguration getConfigFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }


    public static void setStandardConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("Prefix", "&8&l»&7» &9SkyWarsFFA &7| ");
        cfg.addDefault("noPermission", "Dazu hast du &ckeine §7Berechtigung!");
        cfg.addDefault("buildOn", "Du wurdest in den &9Bau Modus &7hinzugefügt.");
        cfg.addDefault("buildOff", "Du wurdest aus den &9Bau Modus &7entfernt.");
        cfg.addDefault("falscheEingabe", "&cFalsche Eingabe&7! Bitte benutze &9/");
        cfg.addDefault("locationSet", "Du hast erfolgreich eine &9Location &7gesetzt ");
        try {
            cfg.save(getConfigFile());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        SkyWarsFFA.Prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("Prefix"));
        SkyWarsFFA.noPermission = ChatColor.translateAlternateColorCodes('&', cfg.getString("noPermission"));
        SkyWarsFFA.buildOn = ChatColor.translateAlternateColorCodes('&', cfg.getString("buildOn"));
        SkyWarsFFA.buildOff = ChatColor.translateAlternateColorCodes('&', cfg.getString("buildOff"));
        SkyWarsFFA.falscheEingabe = ChatColor.translateAlternateColorCodes('&', cfg.getString("falscheEingabe"));
        SkyWarsFFA.locationSet = ChatColor.translateAlternateColorCodes('&', cfg.getString("locationSet"));
    }
}

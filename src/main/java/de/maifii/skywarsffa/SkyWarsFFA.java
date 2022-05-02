package de.maifii.skywarsffa;

import de.maifii.skywarsffa.commands.BuildCommand;
import de.maifii.skywarsffa.commands.SetLocationCommand;
import de.maifii.skywarsffa.listeners.*;
import de.maifii.skywarsffa.listeners.game.RandomChestListener;
import de.maifii.skywarsffa.utils.FileUtils;
import net.forthecrown.royalgrenadier.RoyalGrenadier;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SkyWarsFFA extends JavaPlugin {

    private final File file = new File("plugins/LobbySystem/locations.yml");
    private final YamlConfiguration location = YamlConfiguration.loadConfiguration(this.file);
    private final HashMap<Player, Player> lastDamager = new HashMap<>();

    private static ArrayList<Player> buildMode;

    public static String prefix;
    public static String noPermission;
    public static String buildOn;
    public static String buildOff;
    public static String wrongInput;
    public static String locationSet;

    private static SkyWarsFFA instance;


    @Override
    public void onEnable() {
        instance = this;
        buildMode = new ArrayList<>();

        RoyalGrenadier.initialize(this);

        FileUtils.setStandardConfig();
        FileUtils.readConfig();

        this.register();
        this.loadConfig();
    }

    private void register() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new RandomChestListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new BlockPlaceListener(), this);
        pluginManager.registerEvents(new FoodLevelChangeListener(), this);
        pluginManager.registerEvents(new WeatherChangeListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new EntityDamageByEntityListener(), this);
        pluginManager.registerEvents(new PlayerMoveListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);

        new BuildCommand().register();
        new SetLocationCommand().register();
    }

    private void loadConfig() {
        this.saveDefaultConfig();
        this.reloadConfig();
    }


    @Override
    public void onDisable() {

    }




    //getters
    public static SkyWarsFFA getInstance() {
        return instance;
    }

    @Override
    public @NotNull File getFile() {
        return file;
    }

    public YamlConfiguration getLocation() {
        return location;
    }

    public static ArrayList<Player> getBuildMode() {
        return buildMode;
    }

    public HashMap<Player, Player> getLastDamager() {
        return lastDamager;
    }
}
package de.maifii.skywarsffa;

import de.maifii.skywarsffa.commands.BuildCommand;
import de.maifii.skywarsffa.commands.SetCommand;
import de.maifii.skywarsffa.listeners.*;
import de.maifii.skywarsffa.listeners.game.KitInvListener;
import de.maifii.skywarsffa.listeners.game.RandomChestListener;
import de.maifii.skywarsffa.listeners.game.kits.SoupKitListener;
import de.maifii.skywarsffa.utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SkyWarsFFA extends JavaPlugin {

    private File file = new File("plugins//LobbySystem//locations.yml");
    private YamlConfiguration location = YamlConfiguration.loadConfiguration(this.file);
    private HashMap<Player, Player> lastDamager = new HashMap();

    private static ArrayList<Player> buildMode;
    private static ArrayList<Player> soupKit;

    public static String Prefix;
    public static String noPermission;
    public static String buildOn;
    public static String buildOff;
    public static String falscheEingabe;
    public static String locationSet;

    private static SkyWarsFFA instance;


    @Override
    public void onEnable() {
        instance = this;
        buildMode = new ArrayList<Player>();
        soupKit = new ArrayList<Player>();

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
        pluginManager.registerEvents(new WeatherChangeListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new PlayerMoveListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new EntityDamageByEntityListener(), this);

        pluginManager.registerEvents(new KitInvListener(), this);
        pluginManager.registerEvents(new SoupKitListener(), this);

        getCommand("build").setExecutor(new BuildCommand());
        getCommand("set").setExecutor(new SetCommand());
    }




    @Override
    public void onDisable() {

    }


    private void loadConfig() {
        this.saveDefaultConfig();
        this.reloadConfig();
    }



    //getters
    public static SkyWarsFFA getInstance() {
        return instance;
    }

    @Override
    public File getFile() {
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

    public static ArrayList<Player> getSoupKit() {
        return soupKit;
    }
}
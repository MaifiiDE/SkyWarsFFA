package de.maifii.skywarsffa;

import de.maifii.skywarsffa.command.CommandManager;
import de.maifii.skywarsffa.command.commands.BuildCommand;
import de.maifii.skywarsffa.listeners.*;
import de.maifii.skywarsffa.listeners.game.RandomChestListener;
import de.maifii.skywarsffa.utils.MessageUtils;
import me.wawwior.config.ConfigProvider;
import me.wawwior.config.io.impl.FileInfo;
import me.wawwior.config.io.impl.YamlFileAdapter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashMap;

public class SkyWarsFFA extends JavaPlugin {

    private final CommandManager commandManager = new CommandManager((c, e) -> {
        c.getSource().sendMessage("Incomplete or Invalid Command!");
    });

    private final ConfigProvider<FileInfo> configProvider = new ConfigProvider<>(new YamlFileAdapter("./plugins/SkyWarsFFA"), false);

    private final File file = new File("plugins/LobbySystem/locations.yml");
    private final YamlConfiguration location = YamlConfiguration.loadConfiguration(this.file);
    private final HashMap<Player, Player> lastDamager = new HashMap<>();

    private static SkyWarsFFA instance;

    private MessageUtils messageUtils;

    @Override
    public void onEnable() {
        instance = this;

        messageUtils = new MessageUtils(configProvider);
        messageUtils.load();

        this.register();

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

        commandManager.register(new BuildCommand());

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return commandManager.onCommand(sender, label, args);
    }

    @Override
    public void onDisable() {
        messageUtils.save();
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

    public HashMap<Player, Player> getLastDamager() {
        return lastDamager;
    }

    public ConfigProvider<FileInfo> getConfigProvider() {
        return configProvider;
    }
}
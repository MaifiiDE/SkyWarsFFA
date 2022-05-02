package de.maifii.skywarsffa.commands;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] args) {
        LocationUtils locations = new LocationUtils();

        Player player = (Player) sender;
        if(player.hasPermission("cursedcats.owner")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("spawn")) {
                    locations.setLocation("spawn", player);
                }
                else if(args[0].equalsIgnoreCase("spawnHeight")) {
                    locations.setHeight("spawnHeight", player);
                }
                else if(args[0].equalsIgnoreCase("deathHeight")) {
                    locations.setHeight("deathHeight", player);
                }
                else
                    player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.wrongInput + "set [spawn, spawnHeight, deathHeight]");
            }
            else
                player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.wrongInput + "set [spawn, spawnHeight, deathHeight]");
        }
        else
            player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.noPermission);
        return false;
    }
}

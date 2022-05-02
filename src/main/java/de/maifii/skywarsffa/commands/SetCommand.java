package de.maifii.skywarsffa.commands;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        LocationUtils locations = new LocationUtils();

        Player spieler = (Player) sender;
        if(sender instanceof Player) {
            if(spieler.hasPermission("cursedcats.inhaber")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("Spawn")) {
                        locations.setLocationn("Spawn", spieler);
                    }
                    else if(args[0].equalsIgnoreCase("Spawnheight")) {
                        locations.setHeight("Spawnheight", spieler);
                    }
                    else if(args[0].equalsIgnoreCase("Deathheight")) {
                        locations.setHeight("Deathheight", spieler);
                    }
                    else
                        spieler.sendMessage(SkyWarsFFA.Prefix + SkyWarsFFA.falscheEingabe + "set [Spawn, Spawnheight, Deathheigt]");
                }
                else
                    spieler.sendMessage(SkyWarsFFA.Prefix + SkyWarsFFA.falscheEingabe + "set [Spawn, Spawnheight, Deathheigt]");
            }
            else
                spieler.sendMessage(SkyWarsFFA.Prefix + SkyWarsFFA.noPermission);
        }
        return false;
    }
}

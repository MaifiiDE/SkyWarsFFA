package de.maifii.skywarsffa.commands;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player spieler = (Player) sender;
        if(sender instanceof Player) {
            if(spieler.hasPermission("cursedcats.admin")) {
                if(args.length == 0){
                    if(SkyWarsFFA.getBuildMode().contains(spieler)) {
                        spieler.sendMessage(SkyWarsFFA.Prefix + SkyWarsFFA.buildOff);
                        SkyWarsFFA.getBuildMode().remove(spieler);
                        spieler.setGameMode(GameMode.SURVIVAL);
                        spieler.playSound(spieler.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
                    }
                    else {
                        spieler.sendMessage(SkyWarsFFA.Prefix + SkyWarsFFA.buildOn);
                        SkyWarsFFA.getBuildMode().add(spieler);
                        spieler.setGameMode(GameMode.CREATIVE);
                        spieler.playSound(spieler.getLocation(), Sound.BLOCK_CHEST_OPEN, 1 ,1);
                    }
                }
                else
                    spieler.sendMessage(SkyWarsFFA.Prefix + SkyWarsFFA.falscheEingabe + "build");
            }
            else
                spieler.sendMessage(SkyWarsFFA.Prefix + SkyWarsFFA.noPermission);
        }
        return false;
    }
}

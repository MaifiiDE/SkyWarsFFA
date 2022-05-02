package de.maifii.skywarsffa.commands;

import de.maifii.skywarsffa.SkyWarsFFA;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BuildCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] args) {
        if (!(sender instanceof Player player)) return false;
        if(player.hasPermission("cursedcats.admin")) {
            if(args.length == 0){
                if(SkyWarsFFA.getBuildMode().contains(player)) {
                    player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.buildOff);
                    SkyWarsFFA.getBuildMode().remove(player);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.playSound(player.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
                }
                else {
                    player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.buildOn);
                    SkyWarsFFA.getBuildMode().add(player);
                    player.setGameMode(GameMode.CREATIVE);
                    player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1 ,1);
                }
            }
            else
                player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.wrongInput + "build");
        }
        else
            player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.noPermission);
        return false;
    }
}

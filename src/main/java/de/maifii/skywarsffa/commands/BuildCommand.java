package de.maifii.skywarsffa.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import de.maifii.skywarsffa.SkyWarsFFA;
import net.forthecrown.grenadier.command.AbstractCommand;
import net.forthecrown.grenadier.command.BrigadierCommand;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class BuildCommand extends AbstractCommand {

    public BuildCommand() {
        super("build", SkyWarsFFA.getInstance());

        setPermission("cursedcats.admin");
    }

    @Override
    protected void createCommand(BrigadierCommand builder) {
        builder
                .then(
                        argument("state", BoolArgumentType.bool())
                                .executes(c -> {
                                    Player player = c.getSource().asPlayer();
                                    if (BoolArgumentType.getBool(c, "state")) {
                                        player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.buildOn);
                                        SkyWarsFFA.getBuildMode().add(player);
                                        player.setGameMode(GameMode.CREATIVE);
                                        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1 ,1);
                                    } else {
                                        player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.buildOff);
                                        SkyWarsFFA.getBuildMode().remove(player);
                                        player.setGameMode(GameMode.SURVIVAL);
                                        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
                                    }
                                    return 1;
                                })
                )
                .executes(c -> {
                    Player player = c.getSource().asPlayer();
                    if (SkyWarsFFA.getBuildMode().contains(player)) {
                        player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.buildOff);
                        SkyWarsFFA.getBuildMode().remove(player);
                        player.setGameMode(GameMode.SURVIVAL);
                        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1 ,1);
                    } else {
                        player.sendMessage(SkyWarsFFA.prefix + SkyWarsFFA.buildOn);
                        SkyWarsFFA.getBuildMode().add(player);
                        player.setGameMode(GameMode.CREATIVE);
                        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1 ,1);
                    }
                    return 1;
                });
    }
}

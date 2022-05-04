package de.maifii.skywarsffa.commands;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.MessageUtils;
import de.maifii.skywarsffa.utils.MetadataUtils;
import dev.jorel.commandapi.CommandTree;
import dev.jorel.commandapi.arguments.BooleanArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class BuildCommand extends CommandTree {

    public BuildCommand() {
        super("build");
        this
                .withPermission("cursedcats.admin")
                // -- /build
                .executesPlayer((player, args) -> {
                    setBuild(player, !player.getMetadata("build").contains(MetadataUtils.VALUE_TRUE));
                })
                .then(
                        new PlayerArgument("player")
                                // -- /build <player>
                                .executes((sender, args) -> {
                                    setBuild((Player) args[0], !((Player) args[0]).getMetadata("build").contains(MetadataUtils.VALUE_TRUE));
                                })
                                .then(
                                        new BooleanArgument("state")
                                                // -- /build <player> state
                                                .executes((sender, args) -> {
                                                    setBuild((Player) args[0], (Boolean) args[1]);
                                                })
                                )
                );
    }

    private void setBuild(Player player, boolean state) {
        player.removeMetadata("build", SkyWarsFFA.getInstance());
        player.setMetadata("build", state ? MetadataUtils.VALUE_TRUE : MetadataUtils.VALUE_FALSE);
        player.sendMessage(MessageUtils.messages.prefix + (state ? MessageUtils.messages.buildOn : MessageUtils.messages.buildOff));
        player.setGameMode(state ? GameMode.CREATIVE : GameMode.SURVIVAL);
        player.playSound(player.getLocation(), state ? Sound.BLOCK_CHEST_OPEN : Sound.BLOCK_CHEST_CLOSE, 1, 1);
    }

}

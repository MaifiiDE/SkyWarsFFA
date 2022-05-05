package de.maifii.skywarsffa.command.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.command.AbstractCommand;
import de.maifii.skywarsffa.utils.MessageUtils;
import de.maifii.skywarsffa.utils.MetadataUtils;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand extends AbstractCommand {

    public BuildCommand() {
        super("build");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSender> builder) {
        builder
                .requires(s -> s.hasPermission("cursedcats.admin"))
                .executes(c -> {
                    c.getSource().sendMessage("Hi");
                    return 1;
                })
                .then(
                        literal("one")
                                .executes(c -> 1)
                )
                .then(
                        argument("string", StringArgumentType.greedyString())
                )
                .then(
                        literal("two")
                                .then(
                                        literal("twentyone")
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

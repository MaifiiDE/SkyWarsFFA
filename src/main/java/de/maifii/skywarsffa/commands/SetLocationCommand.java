package de.maifii.skywarsffa.commands;

import de.maifii.skywarsffa.SkyWarsFFA;
import de.maifii.skywarsffa.utils.LocationUtils;
import net.forthecrown.grenadier.command.AbstractCommand;
import net.forthecrown.grenadier.command.BrigadierCommand;
import org.bukkit.plugin.Plugin;

public class SetLocationCommand extends AbstractCommand {

    public SetLocationCommand() {
        super("set", SkyWarsFFA.getInstance());
    }

    @Override
    protected void createCommand(BrigadierCommand builder) {
        builder
                //.withPermission("cursedcats.owner")
                .then(
                        literal("spawn")
                                .executes(c -> {
                                    LocationUtils.setLocation("spawn", c.getSource().asPlayer());
                                    return 1;
                                })
                )
                .then(
                        literal("spawnHeight")
                                .executes(c -> {
                                    LocationUtils.setHeight("spawnHeight", c.getSource().asPlayer());
                                    return 1;
                                })
                )
                .then(
                        literal("deathHeight")
                                .executes(c -> {
                                    LocationUtils.setHeight("deathHeight", c.getSource().asPlayer());
                                    return 1;
                                })
                );
    }
}

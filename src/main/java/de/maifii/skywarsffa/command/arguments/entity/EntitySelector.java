package de.maifii.skywarsffa.command.arguments.entity;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import de.maifii.skywarsffa.command.arguments.EntityArgument;
import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.C;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class EntitySelector {

    private final String selector;

    private final StringReader reader;

    public EntitySelector(String selector, StringReader reader) {
        this.selector = selector;
        this.reader = reader;
    }


    public Player getPlayer(CommandContext<CommandSender> context) throws CommandSyntaxException {

        List<Entity> entities;

        try {
            entities = Bukkit.getServer().selectEntities(context.getSource(), selector);
        } catch (IllegalArgumentException e) {
            throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, context);
        }

        if (!entities.isEmpty()) {
            if (entities.size() == 1) {
                return (Player) entities.get(0);
            }
        }


        throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, context);
    }

    public List<Player> getPlayers(CommandContext<CommandSender> context) throws CommandSyntaxException {

        List<Entity> entities;

        try {
            entities = Bukkit.getServer().selectEntities(context.getSource(), selector);
        } catch (IllegalArgumentException e) {
            throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, context);
        }

        if (entities.stream().allMatch(entity -> entity instanceof Player)) {
            List<Player> players = new ArrayList<>();
            entities.forEach(e -> {
                players.add((Player) e);
            });
            return players;
        }

        throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, context);
    }

    public Entity getEntity(CommandContext<CommandSender> context) throws CommandSyntaxException {

        List<Entity> entities;

        try {
            entities = Bukkit.getServer().selectEntities(context.getSource(), selector);
        } catch (IllegalArgumentException e) {
            throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, context);
        }

        if (!entities.isEmpty()) {
            if (entities.size() == 1) {
                return entities.get(0);
            }
        }

        throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, context);
    }

    public List<Entity> getEntities(CommandContext<CommandSender> context) throws CommandSyntaxException {

        try {
            return Bukkit.getServer().selectEntities(context.getSource(), selector);
        } catch (IllegalArgumentException e) {
            throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, context);
        }


    }

}

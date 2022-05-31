package de.maifii.skywarsffa.command.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.CommandNode;
import de.maifii.skywarsffa.command.arguments.entity.EntitySelector;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EntityArgument implements ArgumentType<EntitySelector> {

    private final boolean multiple;
    private final boolean allowEntities;

    private static final EntityArgument PLAYER = new EntityArgument(false, false);
    private static final EntityArgument PLAYERS = new EntityArgument(true, false);
    private static final EntityArgument ENTITY = new EntityArgument(false, true);
    private static final EntityArgument ENTITIES = new EntityArgument(true, true);

    public EntityArgument(boolean multiple, boolean allowEntities){
        this.multiple = multiple;
        this.allowEntities = allowEntities;
    }

    @Override
    public EntitySelector parse(StringReader reader) throws CommandSyntaxException {

        String selector;

        if (reader.peek() == '@') {
            reader.skip();
            selector = "@" +  reader.readString();
        } else {
            selector = reader.readString();
        }

        return new EntitySelector(selector, reader);
    }

    public static Player getPlayer(CommandContext<CommandSender> context, String argument) throws CommandSyntaxException {
        return context.getArgument(argument, EntitySelector.class).getPlayer(context);
    }

    public static List<Player> getPlayers(CommandContext<CommandSender> context, String argument) throws CommandSyntaxException {
        return context.getArgument(argument, EntitySelector.class).getPlayers(context);
    }

    public static Entity getEntity(CommandContext<CommandSender> context, String argument) throws CommandSyntaxException {
        return context.getArgument(argument, EntitySelector.class).getEntity(context);
    }

    public static List<Entity> getEntities(CommandContext<CommandSender> context, String argument) throws CommandSyntaxException {
        return context.getArgument(argument, EntitySelector.class).getEntities(context);
    }

    public static EntityArgument player() {
        return PLAYER;
    }

    public static EntityArgument players() {
        return PLAYERS;
    }

    public static EntityArgument entity() {
        return ENTITY;
    }

    public static EntityArgument entities() {
        return ENTITIES;
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {

        if (allowEntities) {
            builder.suggest("@s");
            if (multiple) {
                builder.suggest("@e");
            }
        } else {
            builder.suggest("@p");
            builder.suggest("@r");
            if (multiple) {
                builder.suggest("@a");
            }
        }
        return builder.buildFuture();
    }
}

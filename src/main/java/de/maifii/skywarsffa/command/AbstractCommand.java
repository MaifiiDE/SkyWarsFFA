package de.maifii.skywarsffa.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public abstract class AbstractCommand {

    private TreeReducer<CommandSender> reducer = new TreeReducer<>(new HashMap<>(){{
        put(LiteralCommandNode.class, node -> TreeReducer.literal(((LiteralCommandNode<CommandSender>) node).getLiteral()));
        put(ArgumentCommandNode.class, node -> TreeReducer.argument(node.getName(), ((ArgumentCommandNode) node).getType()));
    }});

    private final String name;

    public AbstractCommand(String name) {
        this.name = name;
    }

    protected abstract void build(LiteralArgumentBuilder<CommandSender> builder);

    protected void handle(CommandSyntaxException e) {}

    public String getName() {
        return name;
    }

    public LiteralCommandNode<CommandSender> getSuggestor() {
        LiteralArgumentBuilder<CommandSender> builder = LiteralArgumentBuilder.literal(name);
        build(builder);
        return (LiteralCommandNode<CommandSender>) reducer.reduce(builder.build());
    }

    public CommandNode<CommandSender> getCommand() {
        LiteralArgumentBuilder<CommandSender> builder = LiteralArgumentBuilder.literal(name);
        build(builder);
        return builder.build();
    }

    // Utility

    protected LiteralArgumentBuilder<CommandSender> literal(String name) {
        return LiteralArgumentBuilder.literal(name);
    }

    protected <T> RequiredArgumentBuilder<CommandSender, T> argument(String name, ArgumentType<T> argument) {
        return RequiredArgumentBuilder.argument(name, argument);
    }

}

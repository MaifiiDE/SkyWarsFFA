package de.maifii.skywarsffa.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Map;

public class TreeReducer<T> {


    private Map<Class<?>, NodeCloneFactory<CommandNode<T>>> classes;

    public TreeReducer(Map<Class<?>, NodeCloneFactory<CommandNode<T>>> classes) {
        this.classes = classes;
    }

    public CommandNode<T> reduce(LiteralCommandNode<T> node) {
        return reduce(node, null);
    }


    private CommandNode<T> reduce(CommandNode<T> node, CommandNode<T> parent) {
        if (classes.containsKey(node.getClass())) {
            CommandNode<T> out = classes.get(node.getClass()).clone(node);
            new ArrayList<>(node.getChildren()).forEach(n -> {
                CommandNode<T> n1 = reduce(n, node);
                if (n1 != null) out.addChild(n1);
            });
            return out;
        } else {
            parent.getChildren().remove(node);
            return null;
        }
    }

    public static <T> ArgumentCommandNode<CommandSender, T> argument(String name, ArgumentType<T> argument) {
        return RequiredArgumentBuilder.<CommandSender, T>argument(name, argument).build();
    }

    public static LiteralCommandNode<CommandSender> literal(String literal) {
        return LiteralArgumentBuilder.<CommandSender>literal(literal).build();
    }

}

package de.maifii.skywarsffa.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.CommandNode;
import de.maifii.skywarsffa.command.commands.BuildCommand;
import org.bukkit.command.CommandSender;

class TreeReducerTest {

    public static void main(String[] args) {

        BuildCommand command = new BuildCommand();
        LiteralArgumentBuilder<CommandSender> builder = LiteralArgumentBuilder.literal("build");
        command.build(builder);
        CommandNode<CommandSender> node = command.getSuggestor();
        System.out.println(node.getChildren());
        System.out.println(node.getRequirement());
        System.out.println(builder.build().getChildren());
        System.out.println(builder.build().getRequirement());
    }


}
package de.maifii.skywarsffa.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.lucko.commodore.Commodore;
import org.bukkit.command.CommandSender;

import java.util.function.BiConsumer;

public abstract class AbstractCommand {

    private final LiteralArgumentBuilder<CommandSender> builder;

    private final String name;

    private BiConsumer<CommandContext<CommandSender>, CommandSyntaxException> exceptionHandler = (c, e) -> c.getSource().sendMessage(e.getMessage());

    protected AbstractCommand(String name) {
        this.name = name;
        builder = LiteralArgumentBuilder.literal(name);
        build(builder);
    }

    protected abstract void build(LiteralArgumentBuilder<CommandSender> builder);

    public void register(CommandDispatcher<CommandSender> dispatcher) {
        dispatcher.register(builder);
    }

    public void register(Commodore commodore) {
        commodore.register(builder);
    }

    public BiConsumer<CommandContext<CommandSender>, CommandSyntaxException> getExceptionHandler() {
        return exceptionHandler;
    }

    public void setExceptionHandler(BiConsumer<CommandContext<CommandSender>, CommandSyntaxException> exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public String getName() {
        return name;
    }

    //Utility

    protected <T> RequiredArgumentBuilder<CommandSender, T> argument(String name, ArgumentType<T> type) {
        return RequiredArgumentBuilder.argument(name, type);
    }

    protected LiteralArgumentBuilder<CommandSender> literal(String name) {
        return LiteralArgumentBuilder.literal(name);
    }
}

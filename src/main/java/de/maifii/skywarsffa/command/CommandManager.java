package de.maifii.skywarsffa.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import me.lucko.commodore.Commodore;
import me.lucko.commodore.CommodoreProvider;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

public class CommandManager {

    private final HashMap<String, AbstractCommand> commands = new HashMap<>();

    private final Commodore commodore;

    private final BiConsumer<CommandContext<CommandSender>, CommandSyntaxException> defaultExceptionHandler = (c, e) -> c.getSource().sendMessage(e.getMessage());
    private final CommandDispatcher<CommandSender> dispatcher = new CommandDispatcher<>();

    public CommandManager(Plugin plugin) {
        commodore = CommodoreProvider.getCommodore(plugin);
    }

    public void register(AbstractCommand command) {
        commands.put(command.getName(), command);
        command.register(dispatcher);
        command.register(commodore);
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {

        StringBuilder builder = new StringBuilder();

        for (String arg : args) {
            builder.append(" ");
            builder.append(arg);
        }

        ParseResults<CommandSender> results = dispatcher.parse(label + builder, sender);

        CommandContext<CommandSender> context = results.getContext().build(label + builder);

        System.out.println("Command Execution!");

        try {
            dispatcher.execute(results);
            return true;
        } catch (CommandSyntaxException cse) {
            try {
                commands.get(label).getExceptionHandler().accept(context, cse);
            } catch (NullPointerException npe) {
                defaultExceptionHandler.accept(context, cse);
            }
            return false;
        }

    }

    public List<String> onTabComplete(CommandSender sender, String label, String[] args) {

        StringBuilder builder = new StringBuilder();

        for (String arg : args) {
            builder.append(" ");
            builder.append(arg);
        }

        ParseResults<CommandSender> results = dispatcher.parse(label + builder, sender);

        CompletableFuture<Suggestions> suggestionFuture = dispatcher.getCompletionSuggestions(results);

        Suggestions suggestions;

        try {
            suggestions = suggestionFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> strings = new ArrayList<>();

        suggestions.getList().forEach(s -> strings.add(s.getText()));

        return strings;
    }
}

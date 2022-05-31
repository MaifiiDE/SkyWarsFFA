package de.maifii.skywarsffa.command;

import com.destroystokyo.paper.event.brigadier.AsyncPlayerSendSuggestionsEvent;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

public class CommandManager implements Listener {

    private final CommandDispatcher<CommandSender> dispatcher = new CommandDispatcher<>();

    private final BiConsumer<CommandContext<CommandSender>, CommandSyntaxException> handler;

    private final Map<String, AbstractCommand> commands = new HashMap<>();

    public CommandManager(BiConsumer<CommandContext<CommandSender>, CommandSyntaxException> handler) {
        this.handler = handler;
    }

    public void register(AbstractCommand command) {
        if (!commands.containsKey(command.getName())) {
            commands.put(command.getName(), command);
            dispatcher.getRoot().addChild(command.getCommand());
            //CommodoreProvider.getCommodore(SkyWarsFFA.getInstance()).register(command.getSuggestor());
        }
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {

        StringBuilder stringBuilder = new StringBuilder().append(label);

        for (String s : args) {
            stringBuilder.append(" ").append(s);
        }

        String input = stringBuilder.toString();

        ParseResults<CommandSender> results = dispatcher.parse(input, sender);

        CommandContext<CommandSender> context = results.getContext().build(input);

        try {
            return dispatcher.execute(results) > 0;
        } catch (CommandSyntaxException cse) {
            try {
                commands.get(label).handle(context, cse);
            } catch (NullPointerException npe) {
                handler.accept(context, cse);
            }
        }

        return false;

    }

    @EventHandler
    public void onPlayerSuggest(AsyncPlayerSendSuggestionsEvent event) {

        ParseResults<CommandSender> results = dispatcher.parse(event.getBuffer(), event.getPlayer());

        System.out.println("Buffer: " + event.getBuffer());

        System.out.println("Original: " + event.getSuggestions());

        try {

            Suggestions suggestions = dispatcher.getCompletionSuggestions(results).get();
            System.out.println("New: " + suggestions);

            //event.setSuggestions(suggestions);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        StringBuilder builder = new StringBuilder().append(alias);

        for (String s : args) {
            builder.append(" ").append(s);
        }

        ParseResults<CommandSender> results = dispatcher.parse(builder.toString(), sender);

        try {

            Suggestions suggestions = dispatcher.getCompletionSuggestions(results).get();

            ArrayList<String> out = new ArrayList<>();

            suggestions.getList().forEach(s -> {
                String[] sug = s.apply(builder.toString()).split(" ");
                out.add(sug[sug.length - 1]);
            });

            return out;

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}

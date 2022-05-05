package de.maifii.skywarsffa.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import de.maifii.skywarsffa.SkyWarsFFA;
import me.lucko.commodore.CommodoreProvider;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CommandManager {

    private final CommandDispatcher<CommandSender> dispatcher = new CommandDispatcher<>();

    private final Consumer<CommandSyntaxException> handler;

    private final Map<String, AbstractCommand> commands = new HashMap<>();

    public CommandManager(Consumer<CommandSyntaxException> handler) {
        this.handler = handler;
    }

    public void register(AbstractCommand command) {
        if (!commands.containsKey(command.getName())) {
            commands.put(command.getName(), command);
            dispatcher.getRoot().addChild(command.getCommand());
            CommodoreProvider.getCommodore(SkyWarsFFA.getInstance()).register(command.getSuggestor());
        }
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {

        StringBuilder stringBuilder = new StringBuilder().append(label);

        for (String s : args) {
            stringBuilder.append(" ").append(s);
        }

        String input = stringBuilder.toString();

        ParseResults<CommandSender> results = dispatcher.parse(input, sender);

        try {
            return dispatcher.execute(results) > 0;
        } catch (CommandSyntaxException cse) {
            try {
                commands.get(label).handle(cse);
            } catch (NullPointerException npe) {
                handler.accept(cse);
            }
        }

        return false;

    }

}

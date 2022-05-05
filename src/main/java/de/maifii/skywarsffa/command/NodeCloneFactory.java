package de.maifii.skywarsffa.command;

import com.mojang.brigadier.tree.CommandNode;

public interface NodeCloneFactory<T extends CommandNode> {

    T clone(T t);

}

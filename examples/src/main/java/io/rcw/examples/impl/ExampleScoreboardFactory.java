package io.rcw.examples.impl;

import com.google.inject.Singleton;
import io.rcw.examples.IScoreboard;
import io.rcw.examples.ScoreboardFactory;
import org.bukkit.entity.Player;

/**
 * Implementation of scoreboard factory.
 * Notice: This only does one action, and that is to create a scoreboard for the player.
 * (Chain of responsibility)
 */
@Singleton // Make this a singleton in Guice so it will only be created once upon injection
public final class ExampleScoreboardFactory implements ScoreboardFactory {
    @Override
    public IScoreboard createScoreboard(Player player) {
        return new ExampleScoreboard(player);
    }
}

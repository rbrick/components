package io.rcw.examples.impl;

import io.rcw.examples.Entry;
import io.rcw.examples.IScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Please try using final throughout your code.
 */
public final class ExampleScoreboard implements IScoreboard {

    private final Scoreboard scoreboard;
    private final Objective objective;

    // A scoreboard provides a player to work with.
    public ExampleScoreboard(Player player) {
        // Create a new scoreboard for the player
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        {
            this.objective = this.scoreboard.registerNewObjective("example", "dummy");

            this.objective.setDisplayName("ExampleBoard");
            this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }

        player.setScoreboard(this.scoreboard);
    }

    @Override
    public IScoreboard addEntry(Entry entry) {
        this.objective.getScore(entry.getKey()).setScore(entry.getValue());
        return this;
    }

    @Override
    public IScoreboard removeEntry(Entry entry) {
        this.scoreboard.resetScores(entry.getKey());
        return this;
    }

    @Override
    public IScoreboard removeAll() {
        this.scoreboard.clearSlot(DisplaySlot.SIDEBAR);
        return this;
    }
}

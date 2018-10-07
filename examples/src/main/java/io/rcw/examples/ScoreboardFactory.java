package io.rcw.examples;

import org.bukkit.entity.Player;

/**
 * The (abstract) factory pattern
 */
public interface ScoreboardFactory {
    /**
     * Creates a new scoreboard for the player.
     *
     * @param player The player to set the scoreboard to
     * @return A scoreboard
     */
    IScoreboard createScoreboard(Player player);
}

package io.rcw.examples;

/**
 * This is an example of a simple Scoreboard API using Bukkit's Scoreboard API.
 * We will be using more Java design patterns:
 * http://java-design-patterns.com/patterns/
 *
 * Note: This should not be used in production, I just couldn't think of a better example.
 */
public interface IScoreboard {

    /**
     * Adds a new entry to a scoreboard.
     * @param entry The entry to add
     * @return The current instance of the scoreboard.
     */
    IScoreboard addEntry(Entry entry);


    /**
     * Removes an entry from the board
     * @param entry The entry to remove
     * @return The current instance of the scoreboard.
     */
    IScoreboard removeEntry(Entry entry);

    /**
     * Remove every entry from the scoreboard
     * @return The current instance
     */
    IScoreboard removeAll();
}

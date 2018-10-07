package io.rcw.examples.withoutguice;

import io.rcw.examples.Entry;
import io.rcw.examples.ScoreboardFactory;
import io.rcw.examples.impl.ExampleScoreboardFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WithoutGuicePlugin extends JavaPlugin {

    // Use the implementation we made of ScoreboardFactory.
    private ScoreboardFactory scoreboardFactory = new ExampleScoreboardFactory();

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onJoin(PlayerJoinEvent event) {
                // Create our new scoreboard with our entries.
                scoreboardFactory.createScoreboard(event.getPlayer())
                        .addEntry(new Entry.Builder()
                                .key(ChatColor.RED + "Name:").value(-1).build())
                        .addEntry(new Entry.Builder().key(event.getPlayer().getName()).value(-2).build());
            }
        }, this);

    }
}

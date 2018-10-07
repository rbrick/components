package io.rcw.examples.withguice;

import com.google.inject.Inject;
import io.rcw.examples.Entry;
import io.rcw.examples.ScoreboardFactory;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class JoinListener implements Listener {


    // Now we can go about this one of two ways.


    // This is the second, and arguably cleanest solution:
    // No constructor, just the field you want injected.
    // and call listen(  new JoinListener()   ) (i will switch it back to JoinListener.class soon)
    // listen() hooks directly into the injector and will inject the members of the class marked with
    // '@Inject'
    @Inject
    private ScoreboardFactory scoreboardFactory;

    /**
    @Inject
    public JoinListener(ScoreboardFactory scoreboardFactory) {
        // First solution:
        // Let Guice create the JoinListener, and have Guice invoke the constructor.
        // Guice will pass in the instance it has of ExampleScoreboardFactory
        // That we bound the implementation to. So it will be passed in for us.
        // No more needing to do `new JoinListener()`!
        this.scoreboardFactory = scoreboardFactory;
    }*/


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        scoreboardFactory.createScoreboard(event.getPlayer())
                .addEntry(new Entry.Builder()
                        .key(ChatColor.RED + "Name:").value(-1).build())
                .addEntry(new Entry.Builder().key(event.getPlayer().getName()).value(-2).build());
    }
}

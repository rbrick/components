package io.rcw.components.example.bukkit.scoreboard;

import io.rcw.components.annotations.Inject;
import io.rcw.components.example.bukkit.BukkitComponent;
import io.rcw.components.example.bukkit.ExamplePlugin;
import io.rcw.components.example.bukkit.ExampleScoreboardProvider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ScoreboardComponent extends BukkitComponent {

    public ScoreboardComponent(ExampleScoreboardProvider exampleScoreboardProvider) {
        super();
    }

    @Override
    public void enable() {
        listen(new Listener() {

            @Inject
            private ExamplePlugin plugin;

            @EventHandler
            public void onPlayerJoin(PlayerJoinEvent event) {
                event.setJoinMessage(plugin.getWelcomeMessage());
            }

        });
    }

    @Override
    public void disable() {

    }

    @Override
    public void configure() {
        bind(ScoreboardProvider.class).toInstance(new ExampleScoreboardProvider());
    }
}

package io.rcw.components.example.bukkit;

import io.rcw.components.example.bukkit.scoreboard.ScoreboardComponent;

public final class ExamplePlugin extends ComponentPlugin {
    @Override
    public void configure() {
        install(new ScoreboardComponent(
                new ExampleScoreboardProvider()
        ));
    }

    public String getWelcomeMessage() {
        return "Hello!";
    }
}

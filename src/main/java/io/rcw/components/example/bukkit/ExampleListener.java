package io.rcw.components.example.bukkit;

import io.rcw.components.annotations.Inject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class ExampleListener implements Listener {

    // Inject our plugin
    @Inject
    private ExamplePlugin plugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(plugin.getWelcomeMessage());
    }

}

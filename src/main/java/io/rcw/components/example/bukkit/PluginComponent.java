package io.rcw.components.example.bukkit;

import io.rcw.components.AbstractComponent;
import org.bukkit.plugin.Plugin;

public class PluginComponent extends AbstractComponent {

    private ComponentPlugin plugin;

    public PluginComponent(ComponentPlugin componentPlugin) {
        this.plugin = componentPlugin;
    }

    @Override
    public void configure() {
        bind(Plugin.class).toInstance(this.plugin);
    }
}

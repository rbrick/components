package io.rcw.components.example.bukkit;

import io.rcw.components.AbstractComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class BukkitComponent extends AbstractComponent {

    public abstract void enable();

    public abstract void disable();

    public void listen(Listener listener) {
        Plugin plugin = JavaPlugin.getProvidingPlugin(listener.getClass().getDeclaringClass());
        if (plugin instanceof ComponentPlugin) {
            ((ComponentPlugin) plugin).getComponentInjector().injectMembers(listener);
        }
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }
}

package io.rcw.components.example.bukkit;

import io.rcw.components.Component;
import io.rcw.components.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class ComponentPlugin extends JavaPlugin {

    private List<BukkitComponent> componentSet = new ArrayList<>();

    private Injector injector;

    private Injector componentInjector;

    @Override
    public void onEnable() {
        configure();
        this.injector = Injector.createInjector(new PluginComponent(this));

        this.componentInjector = this.injector.createChildInjector(componentSet.toArray(new Component[]{}));

        componentSet.forEach(BukkitComponent::enable);
    }

    @Override
    public void onDisable() {
        componentSet.forEach(BukkitComponent::disable);
    }

    public abstract void configure();


    public void install(BukkitComponent component) {
        this.componentSet.add(component);
    }

    public Injector getInjector() {
        return injector;
    }

    public Injector getComponentInjector() {
        return componentInjector;
    }
}

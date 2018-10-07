package io.rcw.examples.withguice;

import io.dreamz.api.component.ComponentPlugin;

public final class WithComponentsPlugin extends ComponentPlugin {

    @Override
    public void onEnable() {
        // If you want to override the onEnable method, you can
        // It is just crucial you call the super method before hand!
        // This handles all the logic with Components.
        // OvercastNetwork was able to get rid of this by editing the Bukkit API
        // itself, which I may eventually decide to do.
        // Just remember....
        // CALL THIS IF YOU WANT TO OVERRIDE `onEnable`!!!!!
        super.onEnable();
    }

    @Override
    public void configure() {
        // This is not the same as an onEnable method.
        // This is for configuring which modules will be installed (enabled) on the server
        // There are some limitations using this, that Overcast was able to overcome by integrating
        // the Bukkit API directly with Guice, and adding a Guice module to the JavaPlugin class.
        // I hope I can grow this library to be like Overcast, and as well thought out.


        // Enable the ScoreboardComponent on the server.
        install(new ScoreboardComponent());
    }
}

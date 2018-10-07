package io.rcw.examples.withguice;

import io.dreamz.api.component.BukkitComponent;
import io.rcw.examples.ScoreboardFactory;
import io.rcw.examples.impl.ExampleScoreboardFactory;

/**
 * This is the portion of the plugin that will handle Scoreboards.
 */
public final class ScoreboardComponent extends BukkitComponent {
    @Override
    public void enable() {
        // Our enable methods.

        // Solution 1:
//        Listener listener = this.getInjector().getInstance(JoinListener.class);
//        listen(listener);

        // Solution 2:
        // Our variables are injected for us.
        // Note: getInstance() will inject members too.
        listen(new JoinListener());
    }

    @Override
    public void disable() {

    }

    @Override
    protected void configure() {
        // So, we want our implementation to be ExampleScoreboard
        // And ExampleScoreboardFactory.
        // We will bind the interfaces to their implementations so the injector knows what to
        // create.

        // We cannot bind our implementation of IScoreboard because that constructor is something
        // that cannot be injected.
        // Every constructor (Note: only one instructor) that is to be injected needs to have the '@Inject'
        // And contain parameters that Guice knows about it or it will fail.
        // Guice isn't a god sadly. It doesn't know everything :(

        // Our ScoreboardFactory implementation.
        // ExampleScoreboardFactory is marked with the `@Singleton` annotation
        // which means its lifetime will be through out the lifetime of the server.
        // There will only ever be one instance of the ExampleScoreboardFactory created by Guice.
        bind(ScoreboardFactory.class).to(ExampleScoreboardFactory.class);
    }
}

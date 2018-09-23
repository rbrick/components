package io.rcw.components.example;

import io.rcw.components.AbstractComponent;

public final class ExampleComponent extends AbstractComponent {
    @Override
    public void configure() {
        bind(Food.class).toInstance(new Pork());
    }
}

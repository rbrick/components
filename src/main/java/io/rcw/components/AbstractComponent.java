package io.rcw.components;

import io.rcw.components.inject.Binder;
import io.rcw.components.inject.ScopedBindingBuilder;
import io.rcw.components.inject.internal.BinderImpl;
import io.rcw.components.inject.internal.ScopedBindingBuilderImpl;

public abstract class AbstractComponent implements Component {

    private Binder binder;

    public abstract void configure();

    public void install(Component component) {
        component.configure(this.binder);
    }

    @Override
    public void configure(Binder binder) {
        this.binder = binder;

        configure();
    }

    public <T> ScopedBindingBuilder<T> bind(Class<? extends T> clazz) {
        return new ScopedBindingBuilderImpl<>(((BinderImpl) binder).getDependencyTree(), (Class<T>) clazz);
    }
}

package io.rcw.components.inject;

import io.rcw.components.Component;
import io.rcw.components.inject.internal.InjectorImpl;

public interface Injector {
    <T> T create(Class<? extends T> clazz);
    void injectMembers(Object instance);

    Injector createChildInjector(Component... components);



    static Injector createInjector(Component... components) {
        return new InjectorImpl(components);
    }
}

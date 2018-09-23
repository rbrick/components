package io.rcw.components.inject.internal;

import io.rcw.components.inject.Binding;

public final class BindingImpl<T> implements Binding<T> {
    private Class<T> parent;
    private Class<? extends T> boundType;
    private T instance;

    public BindingImpl(Class<T> parent, Class<? extends T> boundType) {
        this.boundType = boundType;
        this.parent = parent;
    }

    public BindingImpl(Class<T> parent, T instance) {
        this.boundType = (Class<? extends T>) instance.getClass();
        this.instance = instance;
        this.parent = parent;
    }

    @Override
    public Class<? extends T> getBoundType() {
        return boundType;
    }

    @Override
    public T getBoundInstance() {
        return instance;
    }

    @Override
    public Class<T> getParent() {
        return parent;
    }
}

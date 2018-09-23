package io.rcw.components.inject.internal;

import io.rcw.components.Component;
import io.rcw.components.inject.Binder;
import io.rcw.components.inject.Scope;
import io.rcw.components.inject.ScopedBindingBuilder;

public final class BinderImpl implements Binder {

    private DependencyTree tree;

    public BinderImpl(DependencyTree dependencyTree) {
        this.tree = dependencyTree;
    }

    @Override
    public <T> ScopedBindingBuilder<T> bind(Class<T> clazz) {
        return new ScopedBindingBuilderImpl<T>(tree, clazz);
    }

    public DependencyTree getDependencyTree() {
        return tree;
    }
}

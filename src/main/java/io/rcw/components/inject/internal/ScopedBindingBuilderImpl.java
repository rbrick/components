package io.rcw.components.inject.internal;

import io.rcw.components.inject.Scope;
import io.rcw.components.inject.ScopedBindingBuilder;

public final class ScopedBindingBuilderImpl<T> implements ScopedBindingBuilder<T> {

    private final Class<T> parent;
    private DependencyTree dependencyTree;

    private Scope currentScope = Scope.GLOBAL;


    public ScopedBindingBuilderImpl(DependencyTree tree, Class<T> parent) {
        this.dependencyTree = tree;
        this.parent = parent;
    }


    @Override
    public void to(Class<? extends T> clazz) {
        if (currentScope != Scope.GLOBAL) {
            dependencyTree.addScopedDependency(currentScope, new BindingImpl<>(parent, clazz));
        } else {
            dependencyTree.addDependency(new BindingImpl<T>(parent, clazz));
        }
    }


    @Override
    public <I extends T> void toInstance(I instance) {
        if (currentScope != Scope.GLOBAL) {
            dependencyTree.addScopedDependency(currentScope, new BindingImpl<>(parent, instance));
        } else {
            dependencyTree.addDependency(new BindingImpl<T>(parent, instance));
        }

    }


    @Override
    public ScopedBindingBuilder<T> in(Scope scope) {
        this.currentScope = scope;
        return this;
    }
}

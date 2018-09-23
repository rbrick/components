package io.rcw.components.inject.internal;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import io.rcw.components.inject.Binding;
import io.rcw.components.inject.Scope;

import java.util.HashMap;
import java.util.Map;

import static io.rcw.components.inject.Scope.GLOBAL;

public final class DependencyTree {

    // Class ->  Binding look up
    private Table<Scope, Class<?>, Binding<?>> dependencies = HashBasedTable.create();

    public <T> void addDependency(Binding<T> binding) {
        dependencies.put(GLOBAL, binding.getParent(), binding);
    }

    public <T> void addScopedDependency(Scope scope, Binding<T> binding) {
        dependencies.put(scope, binding.getBoundType(), binding);
    }


    public <T> Binding<T> getDependency(Class<?> clazz) {
        return (Binding<T>) this.dependencies.get(GLOBAL, clazz);
    }
}

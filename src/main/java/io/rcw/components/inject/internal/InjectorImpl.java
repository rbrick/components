package io.rcw.components.inject.internal;

import io.rcw.components.Component;
import io.rcw.components.annotations.Inject;
import io.rcw.components.inject.Binding;
import io.rcw.components.inject.Injector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class InjectorImpl implements Injector {

    private DependencyTree dependencyTree = new DependencyTree();


    public InjectorImpl(Component... components) {
        this(new DependencyTree(), components);
    }

    public InjectorImpl(DependencyTree parent, Component... components) {
        this.dependencyTree = parent;
        for (Component component : components) {
            component.configure(new BinderImpl(dependencyTree));
        }
    }


    @Override
    public <T> T create(Class<? extends T> clazz) {
        Binding<? extends T> binding = dependencyTree.getDependency(clazz);

        if (binding != null) {
            if (binding.getBoundInstance() != null) {
                return binding.getBoundInstance();
            } else {
                clazz = binding.getBoundType();
            }
        }

        for (Constructor<?> constructor : clazz.getConstructors()) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                // try to inject our dependencies

                List<Object> parameters = new ArrayList<>();
                for (Class<?> clazzz : constructor.getParameterTypes()) {
                    if (dependencyTree.getDependency(clazzz) != null) {
                        parameters.add(this.create(dependencyTree.getDependency(clazzz).getBoundType()));
                    } else {
                        try {
                            parameters.add(clazzz.newInstance());
                        } catch (InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }

                try {
                    return (T) constructor.newInstance(parameters.toArray());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            } else if (constructor.getParameterCount() == 0) {
                try {
                    T t = (T) constructor.newInstance();
                    this.injectMembers(t);
                    dependencyTree.addDependency(new BindingImpl<T>((Class<T>) clazz, t));
                    return t;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                return null;
            }
        }


        return null;
    }

    @Override
    public void injectMembers(Object instance) {
        for (Field f : instance.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);

                Binding<?> x = dependencyTree.getDependency(f.getType());
                if (x != null) {
                    try {
                        f.set(instance, x.getBoundInstance());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public Injector createChildInjector(Component... components) {
        return new InjectorImpl(this.dependencyTree, components);
    }

}

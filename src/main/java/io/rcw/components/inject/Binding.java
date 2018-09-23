package io.rcw.components.inject;

public interface Binding<T> {
    Class<? extends T> getBoundType();
    T getBoundInstance();

    Class<?> getParent();
}

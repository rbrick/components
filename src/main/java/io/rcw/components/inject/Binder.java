package io.rcw.components.inject;

public interface Binder {
    <T> ScopedBindingBuilder<T> bind(Class<T> clazz);
}

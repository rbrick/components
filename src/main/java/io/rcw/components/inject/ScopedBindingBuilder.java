package io.rcw.components.inject;

public interface ScopedBindingBuilder<T> {
    void to(Class<? extends T> clazz);

     <I extends T> void toInstance(I instance);

    ScopedBindingBuilder<T> in(Scope scope);
}

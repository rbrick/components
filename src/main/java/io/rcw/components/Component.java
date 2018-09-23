package io.rcw.components;

import io.rcw.components.inject.Binder;
import io.rcw.components.inject.ScopedBindingBuilder;

public interface Component {
   void install(Component component);

   void configure(Binder binder);

   <T> ScopedBindingBuilder<T> bind(Class<? extends T> clazz);
}

package io.rcw.components.example;

import io.rcw.components.inject.Injector;

public final class Example {

    public static void main(String[] args) {
        Injector injector = Injector.createInjector(new ExampleComponent());

        Kitchen kitchen = injector.create(Kitchen.class);

        Food food = kitchen.getFood();

        System.out.println("The Kitchen is currently cooking " + food.getName() + " @ " + food.getTemperature() + " degrees");

    }
}

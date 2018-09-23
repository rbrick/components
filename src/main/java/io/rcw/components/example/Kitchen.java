package io.rcw.components.example;

import io.rcw.components.annotations.Inject;

public final class Kitchen {

    private Food food;

    @Inject
    public Kitchen(Food food) {
        this.food = food;
    }

    public Food getFood() {
        return food;
    }
}

package io.rcw.components.example;

public final class Pork implements Food {
    @Override
    public String getName() {
        return "Pork";
    }

    @Override
    public int getTemperature() {
        return 145; // according to USDA
    }
}

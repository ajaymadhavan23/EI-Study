package main.sensors;

import java.util.Random;

public class ThermalSensor {
    private Random random = new Random();

    public double getValue() {
        // Random temp between -50°C and 100°C
        return -50 + random.nextDouble() * 150;
    }
}

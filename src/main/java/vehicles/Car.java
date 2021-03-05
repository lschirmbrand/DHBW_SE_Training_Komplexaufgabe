package vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class Car extends Vehicle implements IVehicle {

    private final int weight;

    public Car() {
        this.weight = ThreadLocalRandom.current().nextInt(850, 1750 + 1);
    }

    public int getWeight() {
        return weight;
    }
}



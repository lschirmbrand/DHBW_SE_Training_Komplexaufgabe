package vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class Truck extends Vehicle implements IVehicle {

    private final int weight;
    private int id;

    public Truck() {
        this.weight = ThreadLocalRandom.current().nextInt(7500, 22750 + 1);
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }
}

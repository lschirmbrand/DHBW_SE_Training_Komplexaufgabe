package vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class Motorbike extends Vehicle implements IVehicle {

    private final int weight;
    private int id;

    public Motorbike() {
        this.weight = ThreadLocalRandom.current().nextInt(225, 375 + 1);
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

package vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class Car implements IVehicle{

    private int weigth;
    private int id;

    public Car(){
        this.weigth = ThreadLocalRandom.current().nextInt(850, 1750 + 1);
    }

    public int getWeigth() {
        return weigth;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return this.id;
    }
}

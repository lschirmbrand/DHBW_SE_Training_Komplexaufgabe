package vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class Truck implements IVehicle{

    private int weigth;
    private int id;

    public Truck(){
        this.weigth = ThreadLocalRandom.current().nextInt(7500, 22750 + 1);
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

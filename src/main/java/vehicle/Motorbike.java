package vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class Motorbike implements IVehicle{

    private int weigth;
    private int id;

    public Motorbike(){
        this.weigth = ThreadLocalRandom.current().nextInt(225, 375 + 1);
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

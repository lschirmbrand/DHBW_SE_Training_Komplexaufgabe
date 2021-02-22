package vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class Car implements IVehicle{

    private int weigth;

    @Override
    public void receiveWeight() {
        this.weigth = ThreadLocalRandom.current().nextInt(850, 1750 + 1);
    }
}

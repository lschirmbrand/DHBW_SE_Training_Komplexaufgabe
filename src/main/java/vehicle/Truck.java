package vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class Truck implements IVehicle{

    private float weigth;

    @Override
    public void receiveWeight() {
        this.weigth = ThreadLocalRandom.current().nextInt(7500, 22750 + 1);
    }
}

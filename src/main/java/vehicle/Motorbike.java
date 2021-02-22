package vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class Motorbike implements IVehicle{

    private float weigth;

    @Override
    public void receiveWeight() {
        this.weigth = ThreadLocalRandom.current().nextInt(225, 375 + 1);
    }
}

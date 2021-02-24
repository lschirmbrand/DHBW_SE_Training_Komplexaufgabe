package barrier;

public class Barrier implements IBarrier {

    private boolean isUp = false;

    @Override
    public void barrierUp() {
        this.isUp = true;
    }

    @Override
    public void barrierDown() {
        this.isUp = false;
    }
}

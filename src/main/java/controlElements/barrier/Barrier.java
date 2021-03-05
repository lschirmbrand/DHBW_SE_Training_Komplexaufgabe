package controlElements.barrier;

public class Barrier implements IBarrier {

    private boolean isUp = false;

    @Override
    public void barrierUp() {
        this.isUp = true;
        System.out.println("Barrier was set: Up\n");
    }

    @Override
    public void barrierDown() {
        this.isUp = false;
        System.out.println("Barrier was set: Down\n");
    }
}

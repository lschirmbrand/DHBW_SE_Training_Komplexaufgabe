package controlElements.barrier.commands;

import controlElements.barrier.Barrier;
import controlcenter.commands.ICommand;

public class BarrierDownCommand implements ICommand {


    private final Barrier barrier;

    public BarrierDownCommand(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void execute() {
        barrier.barrierDown();
    }

}

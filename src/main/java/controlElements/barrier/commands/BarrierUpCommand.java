package controlElements.barrier.commands;

import controlElements.barrier.Barrier;
import controlcenter.commands.ICommand;

public class BarrierUpCommand implements ICommand {

    private final Barrier barrier;

    public BarrierUpCommand(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void execute() {
        barrier.barrierUp();
    }
}

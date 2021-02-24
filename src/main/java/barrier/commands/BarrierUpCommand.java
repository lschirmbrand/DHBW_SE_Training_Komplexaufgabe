package barrier.commands;

import barrier.Barrier;
import controlcenter.commands.ICommand;

public class BarrierUpCommand implements ICommand {

    private Barrier barrier;

    public BarrierUpCommand(Barrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void execute() {
        barrier.barrierUp();
    }
}

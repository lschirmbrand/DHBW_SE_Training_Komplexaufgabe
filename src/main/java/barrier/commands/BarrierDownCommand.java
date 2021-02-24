package barrier.commands;

import barrier.Barrier;
import controlcenter.commands.ICommand;

public class BarrierDownCommand implements ICommand {


    private Barrier barrier;

    public BarrierDownCommand(Barrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void execute() {
        barrier.barrierDown();
    }

}

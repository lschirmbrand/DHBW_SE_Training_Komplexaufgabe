package waitingspace.commands;

import controlcenter.commands.ICommand;
import waitingspace.WaitingSpace;

public class MoveCommand implements ICommand {

    private final WaitingSpace waitingSpace;

    public MoveCommand(WaitingSpace waitingSpace) {
        this.waitingSpace = waitingSpace;
    }

    @Override
    public void execute() {
        waitingSpace.moveVehicle();
    }
}

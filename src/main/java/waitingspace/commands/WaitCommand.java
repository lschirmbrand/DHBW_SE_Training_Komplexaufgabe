package waitingspace.commands;

import controlcenter.commands.ICommand;
import waitingspace.WaitingSpace;

public class WaitCommand implements ICommand {

    private final WaitingSpace waitingSpace;

    public WaitCommand(WaitingSpace waitingSpace) {
        this.waitingSpace = waitingSpace;
    }

    @Override
    public void execute() {
        waitingSpace.waitVehicle();
    }
}
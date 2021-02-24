package controlcenter.commands;

import controlcenter.ControlCenter;

public class MoveCommand implements ICommand{

    private final ControlCenter controlCenter;

    public MoveCommand(ControlCenter controlCenter){
        this.controlCenter = controlCenter;
    }

    @Override
    public void execute() {
        controlCenter.move();
    }
}

package controlcenter.commands;

import controlcenter.ControlCenter;

public class StartWeightCalculationCommand implements ICommand {
    private final ControlCenter controlCenter;

    public StartWeightCalculationCommand(ControlCenter controlCenter) {
        this.controlCenter = controlCenter;
    }

    @Override
    public void execute() {
        controlCenter.startWeightCalculation();
    }
}

package controlcenter.commands;

import controlcenter.ControlCenter;

public class StartFerryFillingCommand {

    private final ControlCenter controlCenter;

    public StartFerryFillingCommand(ControlCenter controlCenter) {
        this.controlCenter = controlCenter;
    }

    public void execute() {
        controlCenter.startFerryFilling();
    }

}

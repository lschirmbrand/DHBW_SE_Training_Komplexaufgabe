package controlElements.trafficLight.commands;

import controlElements.trafficLight.TrafficLight;
import controlcenter.commands.ICommand;

public class TrafficLightGreen implements ICommand {

    private final TrafficLight trafficLight;

    public TrafficLightGreen(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void execute() {
        trafficLight.turnGreen();
    }
}

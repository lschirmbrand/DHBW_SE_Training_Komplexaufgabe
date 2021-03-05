package controlElements.trafficLight.commands;

import controlElements.trafficLight.TrafficLight;
import controlcenter.commands.ICommand;

public class TrafficLightOrange implements ICommand {

    private final TrafficLight trafficLight;

    public TrafficLightOrange(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void execute() {
        trafficLight.turnOrange();
    }
}

package trafficLight.commands;

import controlcenter.commands.ICommand;
import trafficLight.TrafficLight;

public class TrafficLightRed implements ICommand {

    private TrafficLight trafficLight;

    public TrafficLightRed(TrafficLight trafficLight){
        trafficLight.turnRed();
    }

    @Override
    public void execute() {
        trafficLight.turnRed();
    }
}

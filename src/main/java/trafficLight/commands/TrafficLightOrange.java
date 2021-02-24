package trafficLight.commands;

import controlcenter.commands.ICommand;
import trafficLight.TrafficLight;

public class TrafficLightOrange implements ICommand {

    private TrafficLight trafficLight;

    public TrafficLightOrange(TrafficLight trafficLight){
        trafficLight.turnOrange();
    }

    @Override
    public void execute() {

    }
}

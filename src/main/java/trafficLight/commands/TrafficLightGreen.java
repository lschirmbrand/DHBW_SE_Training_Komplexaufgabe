package trafficLight.commands;

import controlcenter.commands.ICommand;
import trafficLight.TrafficLight;

public class TrafficLightGreen implements ICommand {

    private TrafficLight trafficLight;

    public TrafficLightGreen(TrafficLight trafficLight){
        trafficLight.turnGreen();
    }

    @Override
    public void execute() {
        trafficLight.turnGreen();
    }
}

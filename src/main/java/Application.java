import barrier.Barrier;
import barrier.commands.*;
import controlcenter.ControlCenter;
import controlcenter.commands.*;
import trafficLight.TrafficLight;
import trafficLight.commands.*;
import waitingspace.WaitingSpace;

public class Application {
    public static void main(String[] args) {
        WaitingSpace waitingSpace = new WaitingSpace();
        ControlCenter controlCenter = new ControlCenter(waitingSpace);
        StartWeightCalculationCommand startWeightCalculationCommand = new StartWeightCalculationCommand(controlCenter);
        MoveCommand moveCommand = new MoveCommand(controlCenter);
        Barrier barrier = new Barrier();
        BarrierUpCommand barrierUpCommand = new BarrierUpCommand(barrier);
        BarrierDownCommand barrierDownCommand = new BarrierDownCommand(barrier);

        TrafficLight trafficLight = new TrafficLight();
        TrafficLightGreen trafficLightGreen = new TrafficLightGreen(trafficLight);
        TrafficLightOrange trafficLightOrange = new TrafficLightOrange(trafficLight);
        TrafficLightRed trafficLightRed = new TrafficLightRed(trafficLight);


        startWeightCalculationCommand.execute();
    }

}

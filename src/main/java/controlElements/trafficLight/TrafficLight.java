package controlElements.trafficLight;

public class TrafficLight implements ITrafficLight {

    private TrafficLightStateE trafficLightState;

    @Override
    public void turnGreen() {
        this.trafficLightState = TrafficLightStateE.GREEN;
        System.out.println("Traffic Light was turned: Green");
    }

    @Override
    public void turnOrange() {
        this.trafficLightState = TrafficLightStateE.ORANGE;
        System.out.println("Traffic Light was turned: Orange");
    }

}

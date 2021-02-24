package trafficLight;

public class TrafficLight implements ITrafficLight {

    public enum TrafficLightStateE{
        GREEN, ORANGE, RED;
    }

    private TrafficLightStateE trafficLightState = TrafficLightStateE.RED;

    public TrafficLightStateE isGreen() {
        return this.trafficLightState;
    }

    @Override
    public void turnGreen() {
        this.trafficLightState = TrafficLightStateE.GREEN;
    }

    @Override
    public void turnRed() {
        this.trafficLightState = TrafficLightStateE.RED;
    }

    @Override
    public void turnOrange() {
        this.trafficLightState = TrafficLightStateE.ORANGE;
    }
}

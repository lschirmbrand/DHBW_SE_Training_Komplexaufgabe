package controlcenter;

import controlElements.barrier.Barrier;
import controlElements.barrier.commands.BarrierDownCommand;
import controlElements.barrier.commands.BarrierUpCommand;
import controlElements.sensor.VehicleDetector;
import controlElements.trafficLight.TrafficLight;
import controlElements.trafficLight.commands.TrafficLightGreen;
import controlElements.trafficLight.commands.TrafficLightOrange;
import vehicles.Car;
import vehicles.Motorbike;
import vehicles.Truck;
import vehicles.Vehicle;
import waitingspace.WaitingSpace;
import waitingspace.commands.MoveCommand;
import waitingspace.commands.WaitCommand;

import java.util.ArrayList;

public class ControlCenter implements IControlCenter {

    private final WaitingSpace waitingSpace;
    private final ArrayList<Truck> trucks;
    private final ArrayList<Car> cars;
    private final ArrayList<Motorbike> motorbikes;
    private final ArrayList<Vehicle> vehicles;
    private final TrafficLightGreen trafficLightGreen;
    private final TrafficLightOrange trafficLightOrange;
    private final MoveCommand moveCommand;
    private final WaitCommand waitCommand;
    private final BarrierUpCommand barrierUpCommand;
    private final BarrierDownCommand barrierDownCommand;
    private final ArrayList<Truck> lowerDeckLeftParking = new ArrayList<>();
    private final ArrayList<Truck> lowerDeckRightParking = new ArrayList<>();
    private final ArrayList<Car> upperDeckLeftParkingCars = new ArrayList<>();
    private final ArrayList<Car> upperDeckRightParkingCars = new ArrayList<>();
    private final ArrayList<Motorbike> upperDeckRightParkingBikes = new ArrayList<>();
    private final ArrayList<Motorbike> upperDeckLeftParkingBikes = new ArrayList<>();
    VehicleDetector vehicleDetector;
    private boolean isVehicleAtBarrier = false;
    private boolean isVehiclePastBarrier = false;
    private long LeftDeckWeight = 0;
    private long RightDeckWeight = 0;


    public ControlCenter(WaitingSpace waitingSpace) {
        this.waitingSpace = waitingSpace;
        trucks = this.waitingSpace.getTrucks();
        motorbikes = this.waitingSpace.getMotorBikes();
        cars = this.waitingSpace.getCars();
        moveCommand = new MoveCommand(waitingSpace);
        waitCommand = new WaitCommand(waitingSpace);
        vehicles = new ArrayList<>();
        TrafficLight trafficLight = new TrafficLight();
        trafficLightGreen = new TrafficLightGreen(trafficLight);
        trafficLightOrange = new TrafficLightOrange(trafficLight);
        Barrier barrier = new Barrier();
        barrierUpCommand = new BarrierUpCommand(barrier);
        barrierDownCommand = new BarrierDownCommand(barrier);
        vehicleDetector = new VehicleDetector();
        vehicleDetector.addListener(this);

        waitingSpace.setSensor(vehicleDetector);
    }

    @Override
    public void startWeightCalculation() {
        for (Truck s : trucks) {
            if (LeftDeckWeight > RightDeckWeight || lowerDeckLeftParking.size() == 10) {
                lowerDeckRightParking.add(s);
                RightDeckWeight += s.getWeight();
            } else {
                lowerDeckLeftParking.add(s);
                LeftDeckWeight += s.getWeight();
            }
        }

        for (Car s : cars) {
            if ((LeftDeckWeight > RightDeckWeight && upperDeckRightParkingCars.size() != 100) || upperDeckLeftParkingCars.size() == 100) {
                upperDeckRightParkingCars.add(s);
                RightDeckWeight += s.getWeight();
            } else {
                upperDeckLeftParkingCars.add(s);
                LeftDeckWeight += s.getWeight();
            }
        }

        for (Motorbike s : motorbikes) {
            if ((LeftDeckWeight > RightDeckWeight && upperDeckRightParkingBikes.size() != 10) || upperDeckLeftParkingBikes.size() == 10) {
                upperDeckRightParkingBikes.add(s);
                RightDeckWeight += s.getWeight();
            } else {
                upperDeckLeftParkingBikes.add(s);
                LeftDeckWeight += s.getWeight();
            }
        }

        generateSequence();
    }

    @Override
    public void startFerryFilling() {
        waitCommand.execute();
    }

    @Override
    public void moveExecute() {
        moveCommand.execute();
    }

    @Override
    public void waitExecute() {
        waitCommand.execute();
    }

    @Override
    public void generateSequence() {
        for (int i = 0; i < lowerDeckLeftParking.size(); i++) {
            vehicles.add(lowerDeckLeftParking.get(i));
            vehicles.add(lowerDeckRightParking.get(i));
        }
        for (int i = 0; i < upperDeckLeftParkingCars.size(); i++) {
            vehicles.add(upperDeckLeftParkingCars.get(i));
            vehicles.add(upperDeckRightParkingCars.get(i));
        }
        for (int i = 0; i < upperDeckLeftParkingBikes.size(); i++) {
            vehicles.add(upperDeckLeftParkingBikes.get(i));
            vehicles.add(upperDeckRightParkingBikes.get(i));
        }

        waitingSpace.setVehicleInSequence(vehicles);
    }

    @Override
    public void carArrived() {
        System.out.println("Car arrived at barrier");
        isVehiclePastBarrier = false;
        isVehicleAtBarrier = true;
        trafficLightGreen.execute();
        barrierUpCommand.execute();

        moveExecute();
    }

    @Override
    public void carDidCross() {
        System.out.println("Car did cross.");
        isVehicleAtBarrier = false;
        isVehiclePastBarrier = true;
        trafficLightOrange.execute();
        barrierDownCommand.execute();

        waitExecute();
    }

    public ArrayList<Vehicle> getVehicleSequence() {
        return vehicles;
    }


    // Getter for Tests
    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Truck> getTrucks() {
        return trucks;
    }

    public ArrayList<Motorbike> getBikes() {
        return motorbikes;
    }

    public boolean isVehicleAtBarrier() {
        return isVehicleAtBarrier;
    }

    public boolean isVehiclePastBarrier() {
        return isVehiclePastBarrier;
    }

    public long getLeftDeckWeight() {
        return LeftDeckWeight;
    }

    public long getRightDeckWeight() {
        return RightDeckWeight;
    }
}

package waitingspace;

import configuration.Configuration;
import controlElements.sensor.VehicleDetector;
import ferry.Ferry;
import vehicles.Car;
import vehicles.Motorbike;
import vehicles.Truck;
import vehicles.Vehicle;
import waitingspace.display.Display;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class WaitingSpace implements IWaitingSpace {

    private final ArrayList<Car> cars = new ArrayList<Car>();
    private final ArrayList<Truck> trucks = new ArrayList<Truck>();
    private final ArrayList<Motorbike> motorbikes = new ArrayList<Motorbike>();

    private final Ferry ferry;
    private final Display display = new Display();
    private ArrayList<Vehicle> vehicleInSequence = new ArrayList<>();
    private Vehicle vehicleAtBarrier;
    private VehicleDetector vehicleDetector;

    public WaitingSpace(Ferry ferry) {

        this.ferry = ferry;

        for (int i = 0; i < Configuration.instance.numberOfWaitingCars; i++) {
            cars.add(new Car());
        }
        for (int i = 0; i < Configuration.instance.numberOfWaitingTrucks; i++) {
            trucks.add(new Truck());
        }
        for (int i = 0; i < Configuration.instance.numberOfWaitingMotorbikes; i++) {
            motorbikes.add(new Motorbike());
        }
        int id = 0;
        for (Car s : cars) {
            id++;
            s.setID(id);
        }

        for (Truck s : trucks) {
            id++;
            s.setID(id);
        }

        for (Motorbike s : motorbikes) {
            id++;
            s.setID(id);
        }
    }


    @Override
    public void moveVehicle() {
        System.out.println("Command: Move\n");
        if (vehicleAtBarrier instanceof Truck) {
            ferry.parkOnLevelOne(vehicleAtBarrier);
        } else {
            ferry.parkOnLevelTwo(vehicleAtBarrier);
        }
        vehicleDetector.carDidCross();
    }

    @Override
    public void waitVehicle() {
        System.out.println("Command: Wait\n");

        if (vehicleInSequence.size() > 0) {
            setDisplay();
            //nextVehicleArrives();
            vehicleAtBarrier = vehicleInSequence.get(0);
            vehicleInSequence.remove(0);
            vehicleDetector.carAtBarrier();
        }
    }

    @Override
    public void setSensor(VehicleDetector vehicleDetector) {
        this.vehicleDetector = vehicleDetector;
    }

    private void setDisplay() {
        display.displayCurrentVehicle(vehicleInSequence.get(0).getID());
        display.printHeadline();
        System.out.println("ID now: " + display.getIdCurrentVehicle());
        if (vehicleInSequence.size() > 1) {
            display.displayNextVehicle(vehicleInSequence.get(1).getID());
            System.out.println("ID next: " + display.getIdNextVehicle());
        }
        display.printUnderline();
    }


    private void nextVehicleArrives() {
        int random = ThreadLocalRandom.current().nextInt(350, 500 + 1);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Truck> getTrucks() {
        return this.trucks;
    }

    public ArrayList<Motorbike> getMotorBikes() {
        return this.motorbikes;
    }

    public ArrayList<Car> getCars() {
        return this.cars;
    }

    public void setVehicleInSequence(ArrayList<Vehicle> vehicles) {
        this.vehicleInSequence = vehicles;
    }

    public VehicleDetector getDetector() {
        return vehicleDetector;
    }
}

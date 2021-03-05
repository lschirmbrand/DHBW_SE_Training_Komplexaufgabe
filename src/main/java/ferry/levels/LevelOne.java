package ferry.levels;

import parking.ParkingSpace;
import vehicles.Vehicle;

import java.util.ArrayList;

public class LevelOne {

    private final ArrayList<ParkingSpace> leftParking;
    private final ArrayList<ParkingSpace> rightParking;

    private boolean lastVehicleLeft = false;

    public LevelOne() {
        leftParking = new ArrayList<>();
        rightParking = new ArrayList<>();
    }

    public void parkNewVehicle(Vehicle vehicle) {
        if (!lastVehicleLeft) {
            leftParking.add(new ParkingSpace());
            leftParking.get(leftParking.size() - 1).parkVehicle(vehicle);
            lastVehicleLeft = true;
        } else {
            rightParking.add(new ParkingSpace());
            rightParking.get(rightParking.size() - 1).parkVehicle(vehicle);
            lastVehicleLeft = false;
        }
    }

    public ArrayList<ParkingSpace> getLeftParking() {
        return leftParking;
    }

    public ArrayList<ParkingSpace> getRightParking() {
        return rightParking;
    }
}

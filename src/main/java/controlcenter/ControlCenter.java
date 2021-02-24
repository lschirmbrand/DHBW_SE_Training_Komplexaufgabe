package controlcenter;

import vehicle.Car;
import vehicle.IVehicle;
import vehicle.Motorbike;
import vehicle.Truck;
import waitingspace.WaitingSpace;

import java.util.ArrayList;

public class ControlCenter implements IControlCenter {

    private WaitingSpace waitingSpace;
    private ArrayList<Truck> trucks;
    private ArrayList<Car> cars;
    private ArrayList<Motorbike> motorbikes;

    private ArrayList<Truck> lowerDeckLeftParking = new ArrayList<>();
    private ArrayList<Truck> lowerDeckRightParking = new ArrayList<>();
    private ArrayList<Car> upperDeckLeftParkingCars = new ArrayList<>();
    private ArrayList<Car> upperDeckRightParkingCars = new ArrayList<>();
    private ArrayList<Motorbike> upperDeckRightParkingBikes = new ArrayList<>();
    private ArrayList<Motorbike> upperDeckLeftParkingBikes = new ArrayList<>();
    private long LeftDeckWeight = 0;
    private long RightDeckWeight = 0;


    public ControlCenter(WaitingSpace waitingSpace) {
        this.waitingSpace = waitingSpace;
        trucks = this.waitingSpace.getTrucks();
        motorbikes = this.waitingSpace.getMotorBikes();
        cars = this.waitingSpace.getCars();
    }

    @Override
    public void startWeightCalculation() {
        for (Truck s : trucks) {
            if (LeftDeckWeight > RightDeckWeight || lowerDeckLeftParking.size() == 10) {
                lowerDeckRightParking.add(s);
                RightDeckWeight += s.getWeigth();
            } else {
                lowerDeckLeftParking.add(s);
                LeftDeckWeight += s.getWeigth();
            }
        }

        for(Car s : cars ){
            if ((LeftDeckWeight > RightDeckWeight && upperDeckRightParkingCars.size() != 100) || upperDeckLeftParkingCars.size() == 100) {
                upperDeckRightParkingCars.add(s);
                RightDeckWeight += s.getWeigth();
            } else {
                upperDeckLeftParkingCars.add(s);
                LeftDeckWeight += s.getWeigth();
            }
        }

        for(Motorbike s : motorbikes ){
            if ((LeftDeckWeight > RightDeckWeight && upperDeckRightParkingBikes.size() != 10) || upperDeckLeftParkingBikes.size() == 10) {
                upperDeckRightParkingBikes.add(s);
                RightDeckWeight += s.getWeigth();
            } else {
                upperDeckLeftParkingBikes.add(s);
                LeftDeckWeight += s.getWeigth();
            }
        }

        int i = 0;
    }

    @Override
    public void move() {

    }
}

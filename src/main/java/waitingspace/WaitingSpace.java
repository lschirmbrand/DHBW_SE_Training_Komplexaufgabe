package waitingspace;

import configuration.Configuration;
import vehicle.Car;
import vehicle.Motorbike;
import vehicle.Truck;

import java.util.ArrayList;

public class WaitingSpace implements IWaitingSpace{

    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<Truck> trucks = new ArrayList<Truck>();
    private ArrayList<Motorbike> motorbikes = new ArrayList<Motorbike>();

    public WaitingSpace(){
        for(int i = 0; i< Configuration.instance.numberOfWaitingCars; i++){
            cars.add(new Car());
        }
        for(int i = 0; i<Configuration.instance.numberOfWaitingTrucks; i++){
            trucks.add(new Truck());
        }
        for(int i = 0; i<Configuration.instance.numberOfWaitingMotorbikes; i++){
            motorbikes.add(new Motorbike());
        }
        int id = 0;
        for(Car s : cars){
            id++;
            s.setID(id);
            System.out.println("Car: " + s.getID() +" - " +  s.getWeigth() + " kg" );
        }

        for(Truck s : trucks){
            id++;
            s.setID(id);
            System.out.println("Truck: " + s.getID() +" - " +  s.getWeigth() + " kg" );
        }

        for(Motorbike s : motorbikes){
            id++;
            s.setID(id);
            System.out.println("Motorbike: " + s.getID() +" - " +  s.getWeigth() + " kg" );
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
}

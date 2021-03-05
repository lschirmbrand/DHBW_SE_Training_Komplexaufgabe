package waitingspace;

import controlElements.sensor.VehicleDetector;

public interface IWaitingSpace {

    void moveVehicle();

    void waitVehicle();

    void setSensor(VehicleDetector vehicleDetector);
}

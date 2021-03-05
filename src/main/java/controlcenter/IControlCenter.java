package controlcenter;

import controlElements.sensor.IVehicleDetectorListener;

public interface IControlCenter extends IVehicleDetectorListener {
    void startWeightCalculation();

    void startFerryFilling();

    void moveExecute();

    void waitExecute();

    void generateSequence();
}

package controlElements.sensor;

import java.util.ArrayList;

public class VehicleDetector {
    private final ArrayList<IVehicleDetectorListener> listenerList;

    public VehicleDetector() {
        listenerList = new ArrayList<>();
    }

    public void carAtBarrier() {
        for (IVehicleDetectorListener listener : listenerList) {
            listener.carArrived();
        }
    }

    public void carDidCross() {
        for (IVehicleDetectorListener listener : listenerList) {
            listener.carDidCross();
        }
    }

    public void addListener(IVehicleDetectorListener listener) {
        listenerList.add(listener);
    }
}

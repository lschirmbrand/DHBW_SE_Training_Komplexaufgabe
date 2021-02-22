package parking;

public class ParkingSpace {

    public enum ParkingTypeE{
        TRUCK, CAR, MOTORBIKE, ALL
    }

    public ParkingTypeE getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingTypeE parkingType) {
        this.parkingType = parkingType;
    }

    private ParkingTypeE parkingType;
}

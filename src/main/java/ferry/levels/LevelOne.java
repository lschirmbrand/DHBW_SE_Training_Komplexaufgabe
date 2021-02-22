package ferry.levels;

import parking.ParkingSpace;

public class LevelOne {
    private final int rows = 2;
    private final int columns = 5;
    private ParkingSpace[][] leftParking;
    private ParkingSpace[][] rightParking;

    public LevelOne(){
        leftParking = new ParkingSpace[rows][columns];
        rightParking = new ParkingSpace[rows][columns];
        for(int i = 0; i< leftParking.length; i++){
            for(int j = 0; j<leftParking[i].length; j++){
                leftParking[i][j] = new ParkingSpace();
                leftParking[i][j].setParkingType(ParkingSpace.ParkingTypeE.TRUCK);
                rightParking[i][j] = new ParkingSpace();
                rightParking[i][j].setParkingType(ParkingSpace.ParkingTypeE.TRUCK );
            }
        }
    }
}

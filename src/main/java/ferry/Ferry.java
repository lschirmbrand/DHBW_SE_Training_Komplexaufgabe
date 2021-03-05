package ferry;

import ferry.levels.LevelOne;
import ferry.levels.LevelTwo;
import vehicles.Vehicle;

public class Ferry implements IFerry {

    private final LevelOne levelOne = new LevelOne();
    private final LevelTwo levelTwo = new LevelTwo();

    @Override
    public void parkOnLevelOne(Vehicle vehicle) {
        levelOne.parkNewVehicle(vehicle);
    }

    @Override
    public void parkOnLevelTwo(Vehicle vehicle) {
        levelTwo.parkNewVehicle(vehicle);
    }

    public LevelOne getLevelOne() {
        return levelOne;
    }

    public LevelTwo getLevelTwo() {
        return levelTwo;
    }
}

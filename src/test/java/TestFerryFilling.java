import configuration.Configuration;
import controlcenter.ControlCenter;
import controlcenter.commands.StartFerryFillingCommand;
import controlcenter.commands.StartWeightCalculationCommand;
import ferry.Ferry;
import ferry.levels.LevelOne;
import ferry.levels.LevelTwo;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vehicles.Vehicle;
import waitingspace.WaitingSpace;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TestFerryFilling {

    //------------------------------------------------------------------------------//
    //--- Note: Turn off "nextCarArrives()" by making it a comment to prevent    ---//
    //---       waiting 2 Minutes                                                ---//
    //------------------------------------------------------------------------------//

    @Test
    @DisplayName("Check Ferry on Fillstate")
    public void TestFerryAfterFilling() {

        // Create new Ferry
        Ferry ferry = new Ferry();

        // Create Waitingspace and hand it the created ferry
        WaitingSpace waitingSpace = new WaitingSpace(ferry);

        // Create a ControlCenter and hand it control of the waitingspace
        ControlCenter controlCenter = new ControlCenter(waitingSpace);

        ArrayList<Vehicle> vehicles = controlCenter.getVehicleSequence();

        // Instantiate two init-Commands
        StartWeightCalculationCommand startWeightCalculationCommand = new StartWeightCalculationCommand(controlCenter);
        startWeightCalculationCommand.execute();

        // Start the Ferry-Filling-Process
        StartFerryFillingCommand startFerryFillingCommand = new StartFerryFillingCommand(controlCenter);
        startFerryFillingCommand.execute();

        // Get the ferry Levels
        LevelOne levelOne = ferry.getLevelOne();
        LevelTwo levelTwo = ferry.getLevelTwo();

        // Ferry Levels not null
        assertNotNull(levelOne);
        assertNotNull(levelTwo);

        // Check parked Trucks
        assertThat(levelOne.getLeftParking(), not(IsEmptyCollection.empty()));
        assertThat(levelOne.getLeftParking(), hasSize(Configuration.instance.numberOfWaitingTrucks / 2));

        assertThat(levelOne.getRightParking(), not(IsEmptyCollection.empty()));
        assertThat(levelOne.getRightParking(), hasSize(Configuration.instance.numberOfWaitingTrucks / 2));

        // Check parked Cars and Bikes
        assertThat(levelTwo.getLeftParking(), not(IsEmptyCollection.empty()));
        assertThat(levelTwo.getLeftParking(), hasSize((Configuration.instance.numberOfWaitingMotorbikes + Configuration.instance.numberOfWaitingCars) / 2));

        assertThat(levelTwo.getRightParking(), not(IsEmptyCollection.empty()));
        assertThat(levelTwo.getRightParking(), hasSize((Configuration.instance.numberOfWaitingMotorbikes + Configuration.instance.numberOfWaitingCars) / 2));

    }
}

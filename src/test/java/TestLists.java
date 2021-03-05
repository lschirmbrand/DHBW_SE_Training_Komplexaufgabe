import controlcenter.ControlCenter;
import controlcenter.commands.StartWeightCalculationCommand;
import ferry.Ferry;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vehicles.Vehicle;
import waitingspace.WaitingSpace;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

public class TestLists {

    @Test
    @DisplayName("Test List Cars")
    void testListCars() {
        // Create new Ferry
        Ferry ferry = new Ferry();

        // Create Waitingspace and hand it the created ferry
        WaitingSpace waitingSpace = new WaitingSpace(ferry);

        // Create a ControlCenter and hand it control of the waitingspace
        ControlCenter controlCenter = new ControlCenter(waitingSpace);

        ArrayList<Vehicle> vehicles = controlCenter.getVehicleSequence();

        //Instantiate two init-Commands
        StartWeightCalculationCommand startWeightCalculationCommand = new StartWeightCalculationCommand(controlCenter);


        // Assert that Cars List is not empty and has the size 200
        assertThat(controlCenter.getCars(), not(IsEmptyCollection.empty()));
        assertThat(controlCenter.getCars(), hasSize(200));
    }

    @Test
    @DisplayName("Test List Trucks")
    void testListTrucks() {
        // Create new Ferry
        Ferry ferry = new Ferry();

        // Create Waitingspace and hand it the created ferry
        WaitingSpace waitingSpace = new WaitingSpace(ferry);

        // Create a ControlCenter and hand it control of the waitingspace
        ControlCenter controlCenter = new ControlCenter(waitingSpace);

        ArrayList<Vehicle> vehicles = controlCenter.getVehicleSequence();

        //Instantiate two init-Commands
        StartWeightCalculationCommand startWeightCalculationCommand = new StartWeightCalculationCommand(controlCenter);


        // Assert that Trucks List is not empty and has the size 20
        assertThat(controlCenter.getTrucks(), not(IsEmptyCollection.empty()));
        assertThat(controlCenter.getTrucks(), hasSize(20));
    }

    @Test
    @DisplayName("Test List Motorbikes")
    void testListMotorbikes() {
        // Create new Ferry
        Ferry ferry = new Ferry();

        // Create Waitingspace and hand it the created ferry
        WaitingSpace waitingSpace = new WaitingSpace(ferry);

        // Create a ControlCenter and hand it control of the waitingspace
        ControlCenter controlCenter = new ControlCenter(waitingSpace);

        ArrayList<Vehicle> vehicles = controlCenter.getVehicleSequence();

        //Instantiate two init-Commands
        StartWeightCalculationCommand startWeightCalculationCommand = new StartWeightCalculationCommand(controlCenter);


        // Assert that Motorbikes List is not empty and has the size 20
        assertThat(controlCenter.getBikes(), not(IsEmptyCollection.empty()));
        assertThat(controlCenter.getBikes(), hasSize(20));
    }

    @Test
    @DisplayName("Test List of ordered Vehicles")
    void testSequentialList() {
        // Create new Ferry
        Ferry ferry = new Ferry();

        // Create Waitingspace and hand it the created ferry
        WaitingSpace waitingSpace = new WaitingSpace(ferry);

        // Create a ControlCenter and hand it control of the waitingspace
        ControlCenter controlCenter = new ControlCenter(waitingSpace);

        ArrayList<Vehicle> vehicles = controlCenter.getVehicleSequence();

        //Instantiate two init-Commands
        StartWeightCalculationCommand startWeightCalculationCommand = new StartWeightCalculationCommand(controlCenter);
        startWeightCalculationCommand.execute();

        // Assert that all Vehicles in Order-List is not empty and has the size 240
        assertThat(controlCenter.getVehicleSequence(), not(IsEmptyCollection.empty()));
        assertThat(controlCenter.getVehicleSequence(), hasSize(240));
    }
}

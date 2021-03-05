import controlcenter.ControlCenter;
import controlcenter.commands.StartWeightCalculationCommand;
import ferry.Ferry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vehicles.Vehicle;
import waitingspace.WaitingSpace;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWeightCalculation {

    @Test
    @DisplayName("Check Weight Transfer")
    public void testWeightTransfer() {

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

        long leftDeckWeight = controlCenter.getLeftDeckWeight();
        long rightDeckWeight = controlCenter.getRightDeckWeight();

        assertNotEquals(leftDeckWeight, 0);
        assertNotEquals(rightDeckWeight, 0);

        long completeWeight = leftDeckWeight + rightDeckWeight;
        long weightPercent = completeWeight / 100;

        long weightDelta = Math.abs(leftDeckWeight - rightDeckWeight);
        System.out.println(weightDelta);
        System.out.println(weightPercent);

        // 10% weight difference as boundary
        boolean isWeightTransferGood = (weightDelta < 10 * weightPercent);

        assertTrue(isWeightTransferGood);
    }
}

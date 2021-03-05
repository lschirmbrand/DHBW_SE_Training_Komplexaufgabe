import controlcenter.ControlCenter;
import controlcenter.commands.StartFerryFillingCommand;
import controlcenter.commands.StartWeightCalculationCommand;
import ferry.Ferry;
import waitingspace.WaitingSpace;

public class Application {
    public static void main(String[] args) {

        // Create new Ferry
        Ferry ferry = new Ferry();

        // Create Waitingspace and hand it the created ferry
        WaitingSpace waitingSpace = new WaitingSpace(ferry);

        // Create a ControlCenter and hand it control of the waitingspace
        ControlCenter controlCenter = new ControlCenter(waitingSpace);

        //Instantiate two init-Commands
        StartWeightCalculationCommand startWeightCalculationCommand = new StartWeightCalculationCommand(controlCenter);
        StartFerryFillingCommand startFerryFilling = new StartFerryFillingCommand(controlCenter);

        // Start the weightCalculation
        startWeightCalculationCommand.execute();

        // Start filling the ferry
        startFerryFilling.execute();

    }

}

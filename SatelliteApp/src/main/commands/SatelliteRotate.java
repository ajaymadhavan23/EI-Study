package main.commands;

import main.core.Direction;
import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteManager;
import main.core.SatelliteOperationException;

import java.util.Scanner;

public class SatelliteRotate implements SatelliteCommand {

    private Satellite satellite;
    private SatelliteManager manager;

    public SatelliteRotate(Satellite satellite, SatelliteManager manager) {
        this.satellite = satellite;
        this.manager = manager;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        Scanner sc = new Scanner(System.in);
        Direction direction = null;

        while (direction == null) {
            System.out.print("Enter direction (N, S, E, W, NE, NW, SE, SW, etc.): ");
            String userInput = sc.nextLine().trim().toUpperCase();

            try {
                direction = Direction.valueOf(userInput);
                satellite.setOrientation(direction);

                System.out.println("Satellite rotated to: " + satellite.getOrientation());
                System.out.println("Now facing: " + satellite.getFacing());


                manager.updateSatellite(satellite);
            } catch (Exception e) {
                LoggerUtil.logError("Invalid direction input: " + userInput + "Please enter like N, S, E, W, NE, NW, SE, SW...");
                System.out.println();
            }
        }
    }
}

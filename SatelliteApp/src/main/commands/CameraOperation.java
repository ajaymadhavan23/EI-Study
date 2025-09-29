package main.commands;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteOperationException;
import main.core.SatelliteManager;

import java.util.Scanner;

public class CameraOperation implements SatelliteCommand {

    private Satellite satellite;
    private SatelliteManager manager;

    public CameraOperation(Satellite satellite, SatelliteManager manager) {
        this.satellite = satellite;
        this.manager = manager;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        if (satellite.getCamera() == null) {
            LoggerUtil.logError("No camera was found!");
            System.out.println();
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter camera action (on/off): ");
        String userInput = sc.nextLine().trim().toLowerCase();

        switch(userInput) {
            case "on":
                if(!satellite.isCamera()) {
                    satellite.setCamera(true);
                    System.out.println("Camera is On");
                    manager.updateSatellite(satellite);
                } else {
                    LoggerUtil.logError("Camera is already On");
                    System.out.println();
                }
                break;

            case "off":
                if(satellite.isCamera()) {
                    satellite.setCamera(false);
                    System.out.println("Camera is Off");
                    manager.updateSatellite(satellite);
                } else {
                    LoggerUtil.logError("Camera is already Off");
                    System.out.println();
                }
                break;

            default:
                LoggerUtil.logError("Invalid input for Camera. Use 'on' or 'off'.");
                System.out.println();
        }
    }
}

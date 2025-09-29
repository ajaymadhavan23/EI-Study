package main.commands;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteManager;
import main.core.SatelliteOperationException;

import java.util.Scanner;

public class SolarPanelManager implements SatelliteCommand {

    private Satellite satellite;
    private SatelliteManager manager;

    public SolarPanelManager(Satellite satellite, SatelliteManager manager) {
        this.satellite = satellite;
        this.manager = manager;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        Scanner sc = new Scanner(System.in);
        String userInput = null;

        while (true) {
            System.out.print("Enter action for solar panels (activate/deactivate): ");
            userInput = sc.nextLine().trim().toLowerCase();

            switch(userInput) {
                case "activate":
                    if (!satellite.isSolarpanals()) {
                        satellite.setSolarpanals(true);
                        System.out.println("Solar panels activated.");

                        //  UPDATE DASHBOARD
                        manager.updateSatellite(satellite);
                    } else {
                        LoggerUtil.logError("Solar panels already activated.");
                        System.out.println();
                    }
                    return;

                case "deactivate":
                    if (satellite.isSolarpanals()) {
                        satellite.setSolarpanals(false);
                        System.out.println("Solar panels deactivated.");

                        //  UPDATE DASHBOARD
                        manager.updateSatellite(satellite);
                    } else {
                        LoggerUtil.logError("Solar panel already inactive.");
                        System.out.println();
                    }
                    return;

                default:
                    LoggerUtil.logError("Invalid input for SolarPanelManager! Use 'activate' or 'deactivate'.");
                    System.out.println();
            }
        }
    }
}

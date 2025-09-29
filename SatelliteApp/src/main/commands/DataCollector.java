package main.commands;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteOperationException;
import main.core.SatelliteManager;
import java.util.Scanner;

public class DataCollector implements SatelliteCommand {

    private Satellite satellite;
    private SatelliteManager manager; // observer


    public DataCollector(Satellite satellite, SatelliteManager manager) {
        this.satellite = satellite;
        this.manager = manager;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter amount of data to collect: ");
            String userInput = sc.nextLine().trim();

            try {
                int amount = Integer.parseInt(userInput);

                if (satellite.isSolarpanals()) {
                    satellite.setDatacollected(amount);
                    System.out.println("Data collected: " + amount + ". Total: " + satellite.getDatacollected());

                    manager.updateSatellite(satellite);

                } else {
                    LoggerUtil.logError("Cannot collect data. Solar panels inactive.");
                    System.out.println();
                }
                break;
            } catch (NumberFormatException e) {
                LoggerUtil.logError("Invalid input for data collection. Provide integer.");
                System.out.println();
            }
        }
    }
}

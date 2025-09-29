package main.commands;

import main.builder.Builder;
import main.core.Satellite;
import main.core.SatelliteManager;
import main.core.SatelliteOperationException;
import main.core.LoggerUtil;

import java.util.List;
import java.util.Scanner;

public class DefaultSatellite implements SatelliteCommand {

    private final List<Satellite> satellites;
    private final SatelliteManager manager;

    public DefaultSatellite(List<Satellite> satellites, SatelliteManager manager) {
        this.satellites = satellites;
        this.manager = manager;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        Scanner sc = new Scanner(System.in);

        String name = null;
        while (name == null || name.isEmpty()) {
            System.out.print("Enter name for Default Satellite: ");
            name = sc.nextLine().trim();

            String finalName = name;
            boolean exists = satellites.stream().anyMatch(s -> s.getName().equalsIgnoreCase(finalName));
            if (exists) {
                LoggerUtil.logError("Satellite with name '" + name + "' already exists!");
                System.out.println();
                name = null;
            }
        }

        String camChoice = null;
        while (camChoice == null || (!camChoice.equals("1") && !camChoice.equals("2"))) {
            System.out.println("Choose type:");
            System.out.println("1. With Camera");
            System.out.println("2. Without Camera");
            System.out.print("Enter choice: ");
            camChoice = sc.nextLine().trim();
        }

        boolean withCamera = camChoice.equals("1");

        Builder builder = new Builder(name, main.core.Direction.N, false, 0, main.core.Direction.N.name());

        if (withCamera) {
            builder.setCamera(true);
        } else {
            builder.setCamera(null);
        }

        Satellite sat = builder.buildSatellite();

        System.out.println("Default Satellite '" + name + "' created! Camera: " + (withCamera ? "Yes" : "No"));

        //  ADD TO DASHBOARD
        manager.addSatellite(sat);
    }
}

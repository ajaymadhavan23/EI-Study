package main.commands;

import main.builder.Builder;
import main.core.Direction;
import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteOperationException;
import main.core.SatelliteManager;

import java.util.List;
import java.util.Scanner;

public class CreateSatellite implements SatelliteCommand {

    private Satellite satellite;
    private List<Satellite> existingSatellites;
    private SatelliteManager manager; // dashboard/observer


    public CreateSatellite(List<Satellite> existingSatellites, SatelliteManager manager) {
        this.existingSatellites = existingSatellites;
        this.manager = manager;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        Scanner sc = new Scanner(System.in);

        //  SATELLITE NAME
        String name = null;
        while (name == null) {
            System.out.print("Enter Satellite Name: ");
            String tempName = sc.nextLine().trim();
            if (tempName.isEmpty()) {
                LoggerUtil.logError("Satellite name cannot be empty!");
                System.out.println("Please enter a valid satellite name.");
            } else if (existingSatellites.stream().anyMatch(s -> s.getName().equalsIgnoreCase(tempName))) {
                LoggerUtil.logError("This Satellite already exists!");
                System.out.println("Please enter a unique satellite name.");
            } else {
                name = tempName;
            }
        }

        //  ORIENTATION
        Direction orientation = null;
        while (orientation == null) {
            System.out.print("Enter Orientation: ");
            String orientationInput = sc.nextLine().trim().toUpperCase();

            boolean valid = false;
            for (Direction dir : Direction.values()) {
                if (dir.name().equals(orientationInput)) {
                    orientation = dir;
                    valid = true;
                    break;
                }
            }

            if (!valid) {
                LoggerUtil.logInfo("Please Enter valid orientation like (N,S,W,E,NE,NW,SE,SW)");
                LoggerUtil.logError("Invalid orientation!");
                System.out.println();
            }
        }

        //  SOLAR PANELS
        Boolean solar = null;
        while (solar == null) {
            System.out.print("Are solar panels active? (yes/no): ");
            String option = sc.nextLine().trim().toLowerCase();
            if (option.equals("yes")) {
                solar = true;
            } else if (option.equals("no")) {
                solar = false;
            } else {
                LoggerUtil.logError("Invalid input for solar panels! Enter 'yes' or 'no'.");
                System.out.println();
            }
        }

        //  INITIAL DATA COLLECTED
        Integer data = null;
        while (data == null) {
            System.out.print("Enter initial data collected (integer >= 0): ");
            String dataInput = sc.nextLine().trim();
            try {
                int tempData = Integer.parseInt(dataInput);
                if (tempData < 0) {
                    LoggerUtil.logError("Data cannot be negative!, Please enter a number >= 0.");
                    System.out.println();
                } else {
                    data = tempData;
                }
            } catch (NumberFormatException e) {
                LoggerUtil.logError("Invalid input! Data collected must be an integer.");
                System.out.println();
            }
        }

        //  CAMERA
        Boolean camera = null;
        while (camera == null) {
            System.out.print("Include camera? (yes/no): ");
            String cameraInput = sc.nextLine().trim().toLowerCase();
            if (cameraInput.equals("yes")) {
                camera = true;
            } else if (cameraInput.equals("no")) {
                camera = false;
            } else {
                LoggerUtil.logError("Invalid input for camera! Enter 'yes' or 'no'.");
                System.out.println();
            }
        }

        // BUILD SATELLITE
        Builder builder = new Builder(name, orientation, solar, data, orientation.name());
        if (camera) builder.setCamera(true);

        Satellite newSatellite = builder.buildSatellite();
        System.out.println("Satellite '" + name + "' created successfully!");
        this.satellite = newSatellite;

        // ADD ONLY TO MANAGER
        manager.addSatellite(newSatellite);

        // SYNC existingSatellites AFTER adding to manager
        existingSatellites.clear();
        existingSatellites.addAll(manager.getSatellites());

    }

    public Satellite getSatellite() {
        return satellite;
    }
}

package main.app;

import main.commands.CreateSatellite;
import main.commands.SatelliteCommand;
import main.core.Dashboard;
import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteManager;
import main.factories.SatelliteCommandFactory;

import java.util.*;

public class SatelliteApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Satellite> satellites = new ArrayList<>();
        SatelliteManager manager = new SatelliteManager(satellites);

        Dashboard dashboard = new Dashboard(manager);
        dashboard.printTable();

        SatelliteCommandFactory factory;

        while (true) {
            //  MAIN MENU
            String mainChoice = null;
            while (mainChoice == null) {
                System.out.println("\n--- SATELLITE CONTROL MENU ---");
                System.out.println("1. Satellite Operations (rotate, solar, camera, collect, Capture Image, sensor)");
                System.out.println("2. Satellite Management (create, getlist, getstate, addcam, addsensor)");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                String input = sc.nextLine().trim();

                if (input.equals("1") || input.equals("2") || input.equals("3")) {
                    mainChoice = input;
                } else {
                    LoggerUtil.logError("Invalid menu choice!");
                    LoggerUtil.logInfo("Enter 1, 2, or 3");
                    System.out.println();
                }
            }

            try {
                switch (mainChoice) {
                    case "1": // Satellite Operations
                        if (satellites.isEmpty()) {
                            LoggerUtil.logError("No satellites available.");
                            LoggerUtil.logInfo("Please create a satellite first.");
                            System.out.println();
                            break;
                        }

                        String opChoice = null;
                        while (opChoice == null) {
                            System.out.println("\nSATELLITE OPERATION");
                            System.out.println("1. Rotate");
                            System.out.println("2. Solar");
                            System.out.println("3. Camera");
                            System.out.println("4. Collect Data");
                            System.out.println("5. Capture Image");
                            System.out.println("6. Thermal Sensor");
                            System.out.println("7. Back to Main Menu");
                            System.out.print("Choose operation: ");
                            String input = sc.nextLine().trim();

                            if (input.matches("[1-7]")) opChoice = input;
                            else {
                                LoggerUtil.logError("Invalid operation choice!");
                                LoggerUtil.logInfo("Enter a number between 1 and 7");
                                System.out.println();
                            }
                        }

                        if (opChoice.equals("7")) break;

                        Satellite targetSat = null;
                        targetSat = getSatellite(sc, satellites, targetSat);

                        factory = new SatelliteCommandFactory(targetSat, null,manager);
                        String cmdStr = switch (opChoice) {
                            case "1" -> "rotate";
                            case "2" -> "solar";
                            case "3" -> "camera";
                            case "4" -> "collect";
                            case "5" -> "capture";
                            case "6" -> "sensor";
                            default -> null;
                        };

                        if (cmdStr != null) {
                            SatelliteCommand cmd = (SatelliteCommand) factory.getCommand(cmdStr);
                            cmd.execute();
                        }
                        break;

                    case "2": // Satellite Management
                        String mgmtChoice = null;
                        while (mgmtChoice == null) {
                            System.out.println("\n--- SATELLITE MANAGEMENT ---");
                            System.out.println("1. Create Satellite");
                            System.out.println("2. Get List of Satellites");
                            System.out.println("3. Get Satellite State");
                            System.out.println("4. Add Camera");
                            System.out.println("5. Add Thermal Sensor");
                            System.out.println("6. Back to Main Menu");
                            System.out.print("Choose management action: ");
                            String input = sc.nextLine().trim();

                            if (input.matches("[1-6]")) mgmtChoice = input;
                            else {
                                LoggerUtil.logError("Invalid management choice!");
                                LoggerUtil.logInfo("Enter a number between 1 and 6");
                                System.out.println();
                            }
                        }

                        if (mgmtChoice.equals("6")) break;

                        switch (mgmtChoice) {
                            case "1":
                                System.out.println("1. Default Satellite\n2. Custom Satellite");
                                System.out.print("Enter your choice: ");
                                String createOpt = sc.nextLine().trim();

                                factory = new SatelliteCommandFactory(null, satellites,manager);

                                if (createOpt.equals("1")) {
                                    SatelliteCommand cmd = (SatelliteCommand) factory.getCommand("default");
                                    cmd.execute();

                                } else if (createOpt.equals("2")) {
                                    CreateSatellite createCmd = new CreateSatellite(satellites,manager);
                                    createCmd.execute();
                                    Satellite newSat = createCmd.getSatellite();
                                    satellites.add(newSat);
                                    System.out.println("Total satellites: " + satellites.size());
                                }
                                else{
                                    LoggerUtil.logError("Enter valid choice!");
                                    System.out.println();
                                }
                                break;

                            case "2": // Get list
                                factory = new SatelliteCommandFactory(null, satellites,manager);
                                SatelliteCommand getListCmd = (SatelliteCommand) factory.getCommand("getlist");
                                getListCmd.execute();
                                break;

                            case "3": // Get state
                            case "4": // Add Camera
                            case "5": // Add Thermal Sensor
                                if (satellites.isEmpty()) {
                                    LoggerUtil.logError("No satellites found!");
                                    LoggerUtil.logInfo("Please create a satellite first");
                                    System.out.println();
                                    break;
                                }

                                Satellite selected = null;
                                selected = getSatellite(sc, satellites, selected);

                                factory = new SatelliteCommandFactory(selected, satellites,manager);
                                String cmdName = switch (mgmtChoice) {
                                    case "3" -> "getstate";
                                    case "4" -> "addcam";
                                    case "5" -> "addsensor";
                                    default -> null;
                                };

                                SatelliteCommand mgmtCmd = (SatelliteCommand) factory.getCommand(cmdName);
                                mgmtCmd.execute();
                                break;
                        }
                        break;

                    case "3":
                        System.out.println("Exiting Satellite Control...");
                        sc.close();
                        return;
                }

            } catch (Exception e) {
                LoggerUtil.logError(e.getMessage());
                System.out.println();
            }
        }
    }

    private static Satellite getSatellite(Scanner sc, List<Satellite> satellites, Satellite selected) {
        while (selected == null) {
            System.out.print("Enter satellite name: ");
            String nameInput = sc.nextLine().trim();
            selected = satellites.stream()
                    .filter(s -> s.getName().equalsIgnoreCase(nameInput))
                    .findFirst()
                    .orElse(null);

            if (selected == null) {
                LoggerUtil.logError("No satellite with that name!");
                LoggerUtil.logInfo("Enter correct satellite name");
                System.out.println();
            }
        }
        return selected;
    }
}

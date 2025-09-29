package main.core;

public class Dashboard implements Observer {

    private SatelliteManager manager;

    public Dashboard(SatelliteManager manager) {
        this.manager = manager;
        manager.attach(this);
    }

    @Override
    public void update() {
        printTable();
    }

    public void printTable() {
        System.out.println("\n--- DASHBOARD ---");
        // Table column
        System.out.printf("%-3s %-10s %-10s %-5s %-6s %-12s %-10s\n",
                "ID", "Name", "Solar", "Data", "Camera", "Orientation", "Sensor");

        int id = 1;
        for (Satellite s : manager.getSatellites()) {
            String sensorValue = (s.getThermalSensor() == null)
                    ? "Nil"
                    : String.format("%.2f°C", s.getThermalSensor().getValue());

            System.out.printf("%-3d %-10s %-10s %-5d %-6s %-12s %-10s\n",
                    id++,
                    s.getName(),
                    s.isSolarpanals() ? "Active" : "Off",
                    s.getDatacollected(),
                    s.getCamera() == null ? "Nil" : (s.getCamera() ? "On" : "Off"),
                    s.getOrientation() == null ? "Nil" : s.getOrientation().name(),
                    sensorValue
            );
        }
    }
}

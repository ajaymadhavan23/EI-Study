package main.commands;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteOperationException;
import main.sensors.ThermalSensor;

public class ThermalSensorAdapter implements SatelliteCommand {

    private Satellite satellite;

    public ThermalSensorAdapter(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        ThermalSensor sensor = satellite.getThermalSensor();
        if (sensor == null) {
            LoggerUtil.logError("No thermal sensor on this satellite!");
            System.out.println();
            return;
        }

        double temp = sensor.getValue();
        System.out.println("Thermal Sensor Reading: " + String.format("%.2f", temp) + " °C");
    }
}

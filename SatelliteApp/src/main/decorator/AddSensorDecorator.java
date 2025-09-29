package main.decorator;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteOperationException;
import main.sensors.ThermalSensor;
import main.core.SatelliteManager;

public class AddSensorDecorator extends SatelliteDecorator {

    private SatelliteManager manager;

    public AddSensorDecorator(Satellite targetSatellite, SatelliteManager satelliteManager) {
        super(targetSatellite);
        this.manager = satelliteManager;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        if (targetSatellite.getThermalSensor() == null) {
            targetSatellite.setThermalSensor(new ThermalSensor());
            System.out.println("Thermal sensor added to satellite '"
                    + targetSatellite.getName() + "'!");
            manager.updateSatellite(targetSatellite);
        } else {
            LoggerUtil.logError("Satellite '" + targetSatellite.getName() + "' already has a thermal sensor.");
            System.out.println();
        }
    }
}

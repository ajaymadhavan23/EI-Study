package main.commands;

import main.core.Satellite;
import main.core.SatelliteOperationException;
import main.sensors.ThermalSensor;

public class GetState implements SatelliteCommand {
    Satellite satellite;

    public GetState(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        System.out.println("\nGetting state...");
        System.out.println("Direction: "+satellite.getOrientation());
        System.out.println("Direction of Facing: "+satellite.getFacing());

        if (satellite.isSolarpanals()){
            System.out.println("Solar panels : active");
        }
        else{
            System.out.println("Solar panels : inactive");
        }

        System.out.println("Datas Collected: "+satellite.getDatacollected());

        if (satellite.getCamera() != null) {
            System.out.println("Camera: " + (satellite.getCamera() ? "On" : "Off"));
        }

        if(this.satellite.getThermalSensor() != null){
            System.out.println("Sensor: Available");
        }
    }
}

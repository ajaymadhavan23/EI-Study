package main.factories;

import main.commands.*;
import main.core.Satellite;
import main.core.SatelliteManager;
import main.core.SatelliteOperationException;
import main.decorator.AddCameraDecorator;
import main.decorator.AddSensorDecorator;

import java.util.List;

public class SatelliteCommandFactory {

    private Satellite satellite;
    private List<Satellite> satellites;
    private SatelliteManager manager;


    public SatelliteCommandFactory(Satellite satellite, List<Satellite> satellites, SatelliteManager manager) {
        this.satellite = satellite;
        this.satellites = satellites;
        this.manager = manager;
    }

    public Object getCommand(String command) throws SatelliteOperationException {
        switch(command.toLowerCase()) {
            case "create": return new CreateSatellite(satellites,manager);
            case "default": return new DefaultSatellite(satellites,manager);
            case "rotate": return new SatelliteRotate(satellite,manager);
            case "solar": return new SolarPanelManager(satellite,manager);
            case "camera": return new CameraOperation(satellite,manager);
            case "collect": return new DataCollector(satellite,manager);
            case "capture": return new CameraCapture(satellite);
            case "getstate": return new GetState(satellite);
            case "getlist": return new GetList(satellites);
            case "addcam": return new AddCameraDecorator(satellite,manager);
            case "addsensor": return new AddSensorDecorator(satellite,manager);
            case "sensor": return new ThermalSensorAdapter(satellite);


            default: throw new SatelliteOperationException("Unknown command type: " + command);
        }
    }
}

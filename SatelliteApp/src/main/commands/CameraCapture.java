package main.commands;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteOperationException;

public class CameraCapture implements SatelliteCommand {

    private Satellite satellite;

    public CameraCapture(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        if (satellite.getCamera() == null) {
            LoggerUtil.logError("No camera found on this satellite!");
            System.out.println();
            return;
        }

        if (!satellite.isCamera()) {
            LoggerUtil.logError("Camera is off. Turn it on before capturing!");
            System.out.println();
            return;
        }

        if (satellite.getOrientation() == null) {
            LoggerUtil.logError("Orientation not set for satellite!");
            System.out.println();
            return;
        }

        String facing = satellite.getOrientation().getFacing();
        System.out.println("Capturing image towards " + facing + " direction...");
    }
}

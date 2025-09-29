package main.decorator;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteManager;
import main.core.SatelliteOperationException;

public class AddCameraDecorator extends SatelliteDecorator {

    private SatelliteManager manager;

    public AddCameraDecorator(Satellite targetSatellite, SatelliteManager manager) {
        super(targetSatellite);
        this.manager = manager;
    }

    @Override
    public void execute() throws SatelliteOperationException {

        if (targetSatellite.getCamera() == null || !targetSatellite.getCamera()) {
            targetSatellite.setCamera(true);
            System.out.println("Camera has been successfully added to satellite '"
                    + targetSatellite.getName() + "'!");
            manager.updateSatellite(targetSatellite);
        } else {
            LoggerUtil.logError("Satellite '" + targetSatellite.getName() + "' already has a camera.");
            System.out.println();
        }
    }
}

package main.decorator;

import main.commands.SatelliteCommand;
import main.core.Satellite;
import main.core.SatelliteOperationException;

public abstract class SatelliteDecorator implements SatelliteCommand {
    protected SatelliteCommand decoratedCommand;
    protected Satellite targetSatellite;

    public SatelliteDecorator(Satellite targetSatellite) {
        this.targetSatellite = targetSatellite;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        if (decoratedCommand != null) {
            decoratedCommand.execute();
        }
    }
}

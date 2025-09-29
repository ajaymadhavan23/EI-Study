package main.commands;

import main.core.SatelliteOperationException;

public interface SatelliteCommand {
    void execute() throws SatelliteOperationException;

}

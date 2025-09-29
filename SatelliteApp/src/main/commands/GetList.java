package main.commands;

import main.core.LoggerUtil;
import main.core.Satellite;
import main.core.SatelliteOperationException;

import java.util.List;

public class GetList implements SatelliteCommand {

    private List<Satellite> satellites;

    public GetList(List<Satellite> satellites) {
        this.satellites = satellites;
    }

    @Override
    public void execute() throws SatelliteOperationException {
        if (satellites.isEmpty()) {
            LoggerUtil.logError("No satellites found!");
            LoggerUtil.logInfo("Please Create Satellite first");
            System.out.println();
        }
        System.out.println("Available Satellites:");
        for (Satellite s : satellites) {
            System.out.println("- " + s.getName());
        }
    }
}

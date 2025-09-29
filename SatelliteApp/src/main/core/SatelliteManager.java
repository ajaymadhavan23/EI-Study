package main.core;

import java.util.*;

public class SatelliteManager implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private List<Satellite> satellites;

    public SatelliteManager(List<Satellite> satellites) {
        this.satellites = satellites;
    }

    @Override
    public void attach(Observer o) { observers.add(o); }

    @Override
    public void detach(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void addSatellite(Satellite s) {
        satellites.add(s);
        notifyObservers();
    }

    public void updateSatellite(Satellite s) {
        notifyObservers();
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }
}

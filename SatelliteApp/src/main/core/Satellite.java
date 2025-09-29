package main.core;

import main.sensors.ThermalSensor;

public class Satellite {

    private String name;
    private Direction orientation;
    private boolean solarpanals;
    private int datacollected;
    private String facing;
    private Boolean camera;
    private ThermalSensor thermalSensor;

    public Satellite(String name, Direction orientation, boolean solarpanals, int datacollected, String facing, Boolean camera) {
        this.name = name;
        this.orientation = orientation;
        this.solarpanals = solarpanals;
        this.datacollected = datacollected;
        this.facing = orientation.getFacing();
        this.camera = camera;
    }


    // Orientation
    public Direction getOrientation() {
        return orientation;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
        this.facing = orientation.getFacing();
    }

    public boolean isSolarpanals() {
        return solarpanals;
    }

    public void setSolarpanals(boolean solarpanals) {
        this.solarpanals = solarpanals;
    }

    // Data collection
    public int getDatacollected() {
        return datacollected;
    }

    public void setDatacollected(int amt) {
        this.datacollected += amt;
    }

    public String getName() {
        return name;
    }

    public String getFacing() {
        return facing;
    }

    public Boolean getCamera() {
        return camera;
    }

    public void setCamera(Boolean camera) {
        this.camera = camera;
    }

    public boolean isCamera() { return camera != null && camera; }

    public ThermalSensor getThermalSensor() {
        return thermalSensor;
    }

    public void setThermalSensor(ThermalSensor sensor) {
        this.thermalSensor = sensor;
    }

}

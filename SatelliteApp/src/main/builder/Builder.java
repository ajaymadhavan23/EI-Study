package main.builder;

import main.core.Direction;
import main.core.Satellite;

public class Builder {
    private String name;
    private Direction orientation;
    private boolean solarpanals;
    private int datacollected;
    private String facing;
    private Boolean camera = null;

    public Builder(String name,Direction orientation, boolean solarpanals, int datacollected, String facing) {
        this.name = name;
        this.orientation = orientation;
        this.solarpanals = solarpanals;
        this.datacollected = datacollected;
        this.facing = orientation.getFacing();
    }

    public void setCamera(Boolean camera) {
        this.camera = camera;
    }

    public Satellite buildSatellite() {
        return new Satellite(this.name,this.orientation, this.solarpanals, this.datacollected, this.facing, this.camera);
    }
}

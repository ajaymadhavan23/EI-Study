package main.core;

public enum Direction {
    N("North Star"),
    S("South Pole"),
    E("Sunrise"),
    W("Sunset"),
    NE("North-East Horizon"),
    SW("South-West Horizon"),
    SE("South-West Horizon"),
    NW("North-East Horizon");


    private final String facing;

    Direction(String facing) {
        this.facing = facing;
    }

    public String getFacing() {
        return facing;
    }
}

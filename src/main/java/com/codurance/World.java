package com.codurance;

public class World {
    public static final int LOWER_LIMIT = 1;
    private final int xLimit;
    private final int yLimit;

    public World(int xLimit, int yLimit) {
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    public boolean IsInsideYourXUpperLimit(int xCoordinate) {
        return xCoordinate <= xLimit;
    }

    public boolean IsInsideYourYUpperLimit(int yCoordinate) {

        return yCoordinate <= yLimit;
    }

    public boolean IsInsideYourXLowerLimit(int xCoordinate) {
        return xCoordinate >= LOWER_LIMIT;
    }

    public boolean IsInsideYourYLowerLimit(int yCoordinate) {
        return yCoordinate >= LOWER_LIMIT;
    }

    public int xUpperLimit() {
        return xLimit;
    }

    public int yUpperLimit() {
        return yLimit;
    }
}

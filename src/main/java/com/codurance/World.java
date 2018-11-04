package com.codurance;

import java.util.Objects;

public class World {

    static final int LOWER_LIMIT = 1;
    private final int xLimit;
    private final int yLimit;

    public World(int xLimit, int yLimit) {
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    boolean IsInsideYourXUpperLimit(int xCoordinate) {
        return xCoordinate <= xLimit;
    }

    boolean IsInsideYourYUpperLimit(int yCoordinate) {

        return yCoordinate <= yLimit;
    }

    boolean IsInsideYourXLowerLimit(int xCoordinate) {
        return xCoordinate >= LOWER_LIMIT;
    }

    boolean IsInsideYourYLowerLimit(int yCoordinate) {
        return yCoordinate >= LOWER_LIMIT;
    }

    public int xUpperLimit() {
        return xLimit;
    }

    public int yUpperLimit() {
        return yLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        World world = (World) o;
        return xLimit == world.xLimit &&
                yLimit == world.yLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLimit, yLimit);
    }
}

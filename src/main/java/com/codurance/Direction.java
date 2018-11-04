package com.codurance;

import java.util.Objects;

public abstract class Direction {

    private String direction;

    public abstract Direction turnRight();

    public abstract Direction turnLeft();

    public abstract Coordinate moveForward(Coordinate coordinate, World world);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction otherDirection = (Direction) o;
        return Objects.equals(direction, otherDirection.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "direction='" + direction + '\'' +
                '}';
    }
}

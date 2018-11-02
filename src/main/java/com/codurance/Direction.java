package com.codurance;

import java.util.Objects;

public abstract class Direction {

    static final Direction WEST = new WestDirection();
    static final Direction SOUTH = new SouthDirection();
    static final Direction EAST = new EastDirection();
    static final Direction NORTH = new NorthDirection();

    private final String WRONG_DIRECTION = "Why are we here?";
    private String direction;

    public abstract Direction moveRight();

    public abstract Direction moveLeft();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        return Objects.equals(direction, direction1.direction);
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

package com.codurance;

import java.util.Objects;

public class Direction {
    public static final Direction WEST = new Direction("W");
    public static final Direction SOUTH = new Direction("S");
    public static final Direction EAST = new Direction("E");
    public static final Direction NORTH = new Direction("N");
    private final String WRONG_DIRECTION = "Why are we here?";
    private String direction;

    public Direction(String direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        switch (direction) {
            case "E":
                return SOUTH;
            case "S":
                return WEST;
            case "N":
                return EAST;
            case "W":
                return NORTH;
            default:
                throw new RuntimeException(WRONG_DIRECTION);
        }
    }

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

    public Direction turnLeft() {
        switch (direction) {
            case "N":
                return WEST;
            case "W":
                return SOUTH;
            case "S":
                return EAST;
            case "E":
                return NORTH;
            default:
                throw new RuntimeException(WRONG_DIRECTION);
        }
    }
}

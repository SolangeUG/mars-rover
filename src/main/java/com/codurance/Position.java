package com.codurance;

class Position {

    private final World world;
    private Coordinate coordinate;
    private Direction direction;

    Position(World world, Coordinate coordinate, Direction direction) {
        this.world = world;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public World getWorld() {
        return world;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

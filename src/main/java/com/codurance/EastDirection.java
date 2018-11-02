package com.codurance;

class EastDirection extends Direction {

    @Override
    public Direction moveRight() {
        return new SouthDirection();
    }

    @Override
    public Direction moveLeft() {
        return new NorthDirection();
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate, World world) {
        int yValue = coordinate.yCoordinate;
        int xValue = coordinate.xCoordinate + 1;
        if (! world.IsInsideYourXUpperLimit(xValue)) {
            xValue = World.LOWER_LIMIT;
        }
        return new Coordinate(xValue, yValue);
    }
}

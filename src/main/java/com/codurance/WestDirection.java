package com.codurance;

class WestDirection extends Direction {

    @Override
    public Direction moveRight() {
        return new NorthDirection();
    }

    @Override
    public Direction moveLeft() {
        return new SouthDirection();
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate, World world) {
        int yValue = coordinate.yCoordinate;
        int xValue = coordinate.xCoordinate - 1;
        if (! world.IsInsideYourXLowerLimit(xValue)) {
            xValue = world.xUpperLimit();
        }
        return new Coordinate(xValue, yValue);
    }
}
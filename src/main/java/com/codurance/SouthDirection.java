package com.codurance;

class SouthDirection extends Direction {

    @Override
    public Direction turnRight() {
        return new WestDirection();
    }

    @Override
    public Direction turnLeft() {
        return new EastDirection();
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate, World world) {
        int xValue = coordinate.xCoordinate;
        int yValue = coordinate.yCoordinate - 1;
        if (! world.IsInsideYourYLowerLimit(yValue)) {
            yValue = world.yUpperLimit();
        }
        return new Coordinate(xValue, yValue);
    }
}

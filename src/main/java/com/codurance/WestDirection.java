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
    public Coordinate moveForward(Coordinate coordinate) {
        int xValue = coordinate.xCoordinate - 1;
        int yValue = coordinate.yCoordinate;
        return new Coordinate(xValue, yValue);
    }
}

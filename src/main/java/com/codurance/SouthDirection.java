package com.codurance;

class SouthDirection extends Direction {

    @Override
    public Direction moveRight() {
        return new WestDirection();
    }

    @Override
    public Direction moveLeft() {
        return new EastDirection();
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        int xValue = coordinate.xCoordinate;
        int yValue = coordinate.yCoordinate - 1;
        return new Coordinate(xValue, yValue);
    }
}

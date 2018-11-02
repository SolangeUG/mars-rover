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
    public Coordinate moveForward(Coordinate coordinate) {
        int xValue = coordinate.xCoordinate + 1;
        int yValue = coordinate.yCoordinate;
        return new Coordinate(xValue, yValue);
    }
}

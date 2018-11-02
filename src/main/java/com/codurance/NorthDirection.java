package com.codurance;

public class NorthDirection extends Direction {

    @Override
    public Direction moveRight() {
        return new EastDirection();
    }

    @Override
    public Direction moveLeft() {
        return new WestDirection();
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate, World world) {
        int xValue = coordinate.xCoordinate;
        int yValue = coordinate.yCoordinate + 1;
        return new Coordinate(xValue, yValue);
    }
}

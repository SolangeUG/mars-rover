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
    public Coordinate moveForward(Coordinate coordinate) {
        return new Coordinate(0, 0);
    }
}

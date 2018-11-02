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
        return new Coordinate(0, 0);
    }
}

package com.codurance;

class WestDirection extends Direction {

    @Override
    public Direction moveRight() {
        return Direction.NORTH;
    }

    @Override
    public Direction moveLeft() {
        return Direction.SOUTH;
    }
}

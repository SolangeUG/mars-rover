package com.codurance;

class EastDirection extends Direction {

    @Override
    public Direction moveRight() {
        return Direction.SOUTH;
    }

    @Override
    public Direction moveLeft() {
        return Direction.NORTH;
    }
}

package com.codurance;

class SouthDirection extends Direction {

    @Override
    public Direction moveRight() {
        return Direction.WEST;
    }

    @Override
    public Direction moveLeft() {
        return Direction.EAST;
    }
}

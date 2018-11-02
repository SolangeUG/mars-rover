package com.codurance;

public class NorthDirection extends Direction {

    @Override
    public Direction moveRight() {
        return Direction.EAST;
    }

    @Override
    public Direction moveLeft() {
        return Direction.WEST;
    }
}

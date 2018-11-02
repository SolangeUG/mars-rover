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
}

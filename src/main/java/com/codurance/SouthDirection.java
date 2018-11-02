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
}

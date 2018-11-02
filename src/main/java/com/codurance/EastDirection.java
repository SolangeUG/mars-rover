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
}

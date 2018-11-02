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
}

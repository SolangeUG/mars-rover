package com.codurance;

public class LeftCommand implements Command {

    private Direction direction;

    LeftCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction execute() {
        direction = direction.moveLeft();
        return direction;
    }
}

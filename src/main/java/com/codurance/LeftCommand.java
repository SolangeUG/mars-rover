package com.codurance;

public class LeftCommand implements Command {

    private Direction direction;

    LeftCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction execute() {
        this.direction = this.direction.moveLeft();
        return this.direction;
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }
}

package com.codurance;

public class LeftCommand implements Command {


    private Direction direction;

    LeftCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute() {
        this.direction = this.direction.moveLeft();
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }
}

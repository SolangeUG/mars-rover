package com.codurance;

class RightCommand implements Command {

    private Direction direction;

    RightCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction execute() {
        direction = direction.moveRight();
        return direction;
    }
}

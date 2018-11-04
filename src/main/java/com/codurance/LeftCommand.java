package com.codurance;

public class LeftCommand implements Command {

    private Direction direction;

    LeftCommand() {
        super();
    }

    @Override
    public Direction execute() {
        direction = direction.moveLeft();
        return direction;
    }

    @Override
    public void updatePosition(Position position) {
        Direction direction = position.getDirection();
        position.setDirection(direction.moveLeft());
    }
}

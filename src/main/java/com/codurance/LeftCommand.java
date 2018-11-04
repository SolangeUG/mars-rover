package com.codurance;

public class LeftCommand implements Command {

    LeftCommand() {
        super();
    }

    @Override
    public void update(Position position) {
        Direction direction = position.getDirection();
        position.setDirection(direction.turnLeft());
    }
}

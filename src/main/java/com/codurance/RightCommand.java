package com.codurance;

class RightCommand implements Command {

    RightCommand() {
        super();
    }

    @Override
    public void update(Position position) {
        Direction  direction = position.getDirection();
        position.setDirection(direction.turnRight());
    }
}

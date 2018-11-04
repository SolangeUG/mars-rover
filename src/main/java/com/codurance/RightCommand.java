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

    @Override
    public void updatePosition(Position position) {
        Direction  direction = position.getDirection();
        position.setDirection(direction.moveRight());
    }
}

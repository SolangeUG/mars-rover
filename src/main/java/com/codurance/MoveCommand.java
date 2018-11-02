package com.codurance;

public class MoveCommand implements Command {

    private Coordinate position;
    private final Direction direction;

    MoveCommand(Coordinate position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    @Override
    public Object execute() {
        position = direction.moveForward(position);
        return this.position;
    }

    boolean isCoordinate(Coordinate coordinate) {
        return position.equals(coordinate);
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }
}

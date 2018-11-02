package com.codurance;

public class MoveCommand implements Command {

    private Coordinate position;
    private final Direction direction;
    private World world;

    MoveCommand(Coordinate position, Direction direction, World world) {
        this.position = position;
        this.direction = direction;
        this.world = world;
    }

    @Override
    public Coordinate execute() {
        position = direction.moveForward(position, world);
        return this.position;
    }

    boolean isCoordinate(Coordinate coordinate) {
        return position.equals(coordinate);
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }
}

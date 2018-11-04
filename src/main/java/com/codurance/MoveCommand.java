package com.codurance;

public class MoveCommand implements Command {

    private Coordinate coordinate;
    private final Direction direction;
    private World world;

    MoveCommand(Coordinate coordinate, Direction direction, World world) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.world = world;
    }

    @Override
    public Coordinate execute() {
        coordinate = direction.moveForward(coordinate, world);
        return this.coordinate;
    }

    @Override
    public void updatePosition(Position position) {
        World world = position.getWorld();
        Coordinate coordinate = position.getCoordinate();
        Direction direction = position.getDirection();
        position.setCoordinate(direction.moveForward(coordinate, world));
    }

    boolean isCoordinate(Coordinate coordinate) {
        return this.coordinate.equals(coordinate);
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }
}

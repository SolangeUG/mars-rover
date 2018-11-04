package com.codurance;

public class MoveCommand implements Command {

    private Coordinate coordinate;
    private Direction direction;
    private World world;
    private Position position;

    MoveCommand(Position position) {
        this.position = position;
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
        this.coordinate = position.getCoordinate();
        return this.coordinate.equals(coordinate);
    }

    boolean isDirection(Direction direction) {
        this.direction = position.getDirection();
        return this.direction.equals(direction);
    }
}

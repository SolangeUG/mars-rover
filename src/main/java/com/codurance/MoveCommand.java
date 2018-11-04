package com.codurance;

public class MoveCommand implements Command {

    private Position position;

    MoveCommand(Position position) {
        this.position = position;
    }

    @Override
    public void update(Position position) {
        World world = position.getWorld();
        Coordinate coordinate = position.getCoordinate();
        Direction direction = position.getDirection();
        position.setCoordinate(direction.moveForward(coordinate, world));
    }

    boolean isCoordinate(Coordinate coordinate) {
        Coordinate posCoordinate = position.getCoordinate();
        return posCoordinate.equals(coordinate);
    }

    boolean isDirection(Direction direction) {
        Direction posDirection = position.getDirection();
        return posDirection.equals(direction);
    }
}

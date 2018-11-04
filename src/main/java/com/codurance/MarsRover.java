package com.codurance;

import java.util.List;

class MarsRover {
    private Coordinate coordinate;
    private Direction direction;
    private Position position;

    MarsRover(World world, Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.position = new Position(world, coordinate, direction);
    }

    void move(List<Command> commands) {
        for (Command command: commands) {
            command.update(position);
            direction = position.getDirection();
            coordinate = position.getCoordinate();
        }
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }

    boolean isPosition(int xPosition, int yPosition) {
        return coordinate.xCoordinate == xPosition
                && coordinate.yCoordinate == yPosition;
    }
}

package com.codurance;

import java.util.List;

class MarsRover {
    private Position position;

    MarsRover(World world, Coordinate coordinate, Direction direction) {
        this.position = new Position(world, coordinate, direction);
    }

    void move(List<Command> commands) {
        for (Command command: commands) {
            command.update(position);
        }
    }

    boolean isDirection(Direction direction) {
        Direction myDirection = position.getDirection();
        return myDirection.equals(direction);
    }

    boolean isPosition(int xPosition, int yPosition) {
        Coordinate myCoordinate = position.getCoordinate();
        return myCoordinate.xCoordinate == xPosition
                && myCoordinate.yCoordinate == yPosition;
    }
}

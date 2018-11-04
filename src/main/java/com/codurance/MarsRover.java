package com.codurance;

import java.util.List;

class MarsRover {
    private World world;
    private Coordinate coordinate;
    private Direction direction;
    private Position position;

    MarsRover(World world, Coordinate coordinate, Direction direction) {
        this.world = world;
        this.coordinate = coordinate;
        this.direction = direction;
        this.position = new Position(world, coordinate, direction);
    }

    void move(String moveCommand) {
        switch (moveCommand) {
            case "L":
                moveLeft();
                break;
            case "R":
                moveRight();
                break;
            default:
                moveForward();
                break;
        }
    }

    private void moveLeft() {
        LeftCommand command = new LeftCommand(direction);
        // direction = command.execute();
        Position position = new Position(world, coordinate, direction);
        command.updatePosition(position);
        direction = position.getDirection();
    }

    private void moveRight() {
        RightCommand command = new RightCommand(direction);
        // direction = command.execute();
        Position position = new Position(world, coordinate, direction);
        command.updatePosition(position);
        direction = position.getDirection();
    }

    private void moveForward() {
        MoveCommand command = new MoveCommand(coordinate, direction, world);
        // coordinate = command.execute();
        Position position = new Position(world, coordinate, direction);
        command.updatePosition(position);
        coordinate = position.getCoordinate();
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }

    boolean isPosition(int xPosition, int yPosition) {
        return coordinate.xCoordinate == xPosition && coordinate.yCoordinate == yPosition;
    }

    void updatePosition(List<Command> commands) {
        for (Command command: commands) {
            command.updatePosition(position);
            direction = position.getDirection();
            coordinate = position.getCoordinate();
        }
    }
}

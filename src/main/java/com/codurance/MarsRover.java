package com.codurance;

class MarsRover {
    private World world;
    private Coordinate coordinate;
    private Direction direction;

    MarsRover(World world, Coordinate coordinate, Direction direction) {
        this.world = world;
        this.coordinate = coordinate;
        this.direction = direction;
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
        direction = command.execute();
    }

    private void moveRight() {
        RightCommand command = new RightCommand(direction);
        direction = command.execute();
    }

    private void moveForward() {
        MoveCommand command = new MoveCommand(coordinate, direction, world);
        coordinate = command.execute();
    }

    boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }

    boolean isPosition(int xPosition, int yPosition) {
        return coordinate.xCoordinate == xPosition && coordinate.yCoordinate == yPosition;
    }
}

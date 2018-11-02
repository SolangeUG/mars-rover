package com.codurance;

public class MarsRover {
    private World world;
    private Coordinate coordinate;
    private Direction direction;

    public MarsRover(World world, Coordinate coordinate, Direction direction) {
        this.world = world;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public void move(String moveCommand) {
        if (moveCommand.equals("L")) {
            turnLeft();
        } else if (moveCommand.equals("R")) {
            turnRight();
        } else {
            moveForward();
            wrapPosition();
        }
    }

    private void wrapPosition() {
        if (!world.IsInsideYourXUpperLimit(coordinate.xCoordinate))
            this.coordinate.xCoordinate = World.LOWER_LIMIT;
        if (!world.IsInsideYourXLowerLimit(coordinate.xCoordinate))
            this.coordinate.xCoordinate = world.xUpperLimit();
        if (!world.IsInsideYourYUpperLimit(coordinate.yCoordinate))
            this.coordinate.yCoordinate = World.LOWER_LIMIT;
        if (!world.IsInsideYourYLowerLimit(coordinate.yCoordinate))
            this.coordinate.yCoordinate = world.yUpperLimit();
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    private void moveForward() {
        if (direction == Direction.WEST)
            this.coordinate.xCoordinate -= 1;
        else if (direction == Direction.EAST)
            this.coordinate.xCoordinate += 1;
        else if (direction == Direction.NORTH)
            this.coordinate.yCoordinate += 1;
        else
            this.coordinate.yCoordinate -= 1;
    }

    public boolean isDirection(Direction direction) {
        return this.direction.equals(direction);
    }

    public boolean isPosition(int xPosition , int yPosition) {
        return coordinate.xCoordinate == xPosition && coordinate.yCoordinate == yPosition;
    }
}

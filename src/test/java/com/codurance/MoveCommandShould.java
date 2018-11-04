package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveCommandShould {

    private final int xUpperLimit = 3;
    private final int yUpperLimit = 3;
    private final World world = new World(xUpperLimit, yUpperLimit);
    private Coordinate coordinate = new Coordinate(2, 2);

    @Test
    void when_moving_east_increment_x_coordinate() {
        Direction direction = new EastDirection();
        Position position = new Position(world, coordinate, direction);
        MoveCommand command = new MoveCommand(position);

        command.updatePosition(position);
        Coordinate expected = new Coordinate(3, 2);

        assertThat(command.isCoordinate(expected)).isTrue();
        assertThat(command.isDirection(direction)).isTrue();
    }

    @Test
    void when_moving_west_decrement_x_coordinate() {
        Direction direction = new WestDirection();
        Position position = new Position(world, coordinate, direction);
        MoveCommand command = new MoveCommand(position);

        command.updatePosition(position);
        Coordinate expected = new Coordinate(1, 2);

        assertThat(command.isCoordinate(expected)).isTrue();
        assertThat(command.isDirection(direction)).isTrue();
    }

    @Test
    void when_moving_north_increment_y_coordinate() {
        Direction direction = new NorthDirection();
        Position position = new Position(world, coordinate, direction);
        MoveCommand command = new MoveCommand(position);

        command.updatePosition(position);
        Coordinate expected = new Coordinate(2, 3);

        assertThat(command.isCoordinate(expected)).isTrue();
        assertThat(command.isDirection(direction)).isTrue();
    }

    @Test
    void when_moving_south_decrement_y_coordinate() {
        Direction direction = new SouthDirection();
        Position position = new Position(world, coordinate, direction);
        MoveCommand command = new MoveCommand(position);

        command.updatePosition(position);
        Coordinate expected = new Coordinate(2, 1);

        assertThat(command.isCoordinate(expected)).isTrue();
        assertThat(command.isDirection(direction)).isTrue();
    }

}

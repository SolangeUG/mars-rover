package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveCommandShould {

    @Test
    void when_moving_east_increment_x_coordinate() {
        Coordinate position = new Coordinate(2, 2);
        Direction direction = new EastDirection();
        MoveCommand command = new MoveCommand(position, direction);

        command.execute();
        Coordinate expected = new Coordinate(3, 2);

        assertThat(command.isCoordinate(expected)).isTrue();
        assertThat(command.isDirection(direction)).isTrue();
    }

    @Test
    void when_moving_west_decrement_x_coordinate() {
        Coordinate position = new Coordinate(2, 2);
        Direction direction = new WestDirection();
        MoveCommand command = new MoveCommand(position, direction);

        command.execute();
        Coordinate expected = new Coordinate(1, 2);

        assertThat(command.isCoordinate(expected)).isTrue();
        assertThat(command.isDirection(direction)).isTrue();
    }

}

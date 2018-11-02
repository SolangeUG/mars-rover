package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WestDirectionShould {

    private final int xUpperLimit = 3;
    private final int yUpperLimit = 3;
    private final World world = new World(xUpperLimit, yUpperLimit);

    @Test
    void return_south_when_asked_to_turn_left() {
        WestDirection west = new WestDirection();
        assertThat(west.moveLeft()).isEqualTo(new SouthDirection());
    }

    @Test
    void return_north_when_asked_to_move_right() {
        WestDirection west = new WestDirection();
        assertThat(west.moveRight()).isEqualTo(new NorthDirection());
    }

    @Test
    void decrement_x_coordinate_when_asked_to_move_forward() {
        Coordinate coordinate = new Coordinate(2, 2);
        WestDirection west = new WestDirection();

        Coordinate expected = new Coordinate(1, 2);
        assertThat(west.moveForward(coordinate, world)).isEqualTo(expected);
    }

    @Test
    void wrap_around_the_world_if_position_is_on_edge() {
        Coordinate coordinate = new Coordinate(1, 2);
        WestDirection west = new WestDirection();

        Coordinate expected = new Coordinate(xUpperLimit, 2);
        assertThat(west.moveForward(coordinate, world)).isEqualTo(expected);
    }
}

package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NorthDirectionShould {

    private final int xUpperLimit = 3;
    private final int yUpperLimit = 3;
    private final World world = new World(xUpperLimit, yUpperLimit);

    @Test
    void change_to_east_when_asked_to_move_right() {
        Direction north = new NorthDirection();
        assertThat(north.turnRight()).isEqualTo(new EastDirection());
    }

    @Test
    void change_to_west_when_asked_to_move_right() {
        Direction north = new NorthDirection();
        assertThat(north.turnLeft()).isEqualTo(new WestDirection());
    }

    @Test
    void increment_y_coordinate_when_asked_to_move_forward() {
        Coordinate coordinate = new Coordinate(2, 2);
        NorthDirection north = new NorthDirection();

        Coordinate expected = new Coordinate(2, 3);
        assertThat(north.moveForward(coordinate, world)).isEqualTo(expected);
    }

    @Test
    void wrap_around_the_world_if_position_is_on_edge() {
        Coordinate coordinate = new Coordinate(2, 3);
        NorthDirection north = new NorthDirection();

        Coordinate expected = new Coordinate(2, World.LOWER_LIMIT);
        assertThat(north.moveForward(coordinate, world)).isEqualTo(expected);
    }
}

package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SouthDirectionShould {

    private final int xUpperLimit = 3;
    private final int yUpperLimit = 3;
    private final World world = new World(xUpperLimit, yUpperLimit);

    @Test
    void change_to_west_when_asked_to_move_right() {
        SouthDirection south = new SouthDirection();
        assertThat(south.moveRight()).isEqualTo(new WestDirection());
    }

    @Test
    void change_to_east_when_asked_to_move_left() {
        SouthDirection south = new SouthDirection();
        assertThat(south.moveLeft()).isEqualTo(new EastDirection());
    }

    @Test
    void decrement_y_coordinate_when_asked_to_move_forward() {
        Coordinate coordinate = new Coordinate(2, 2);
        SouthDirection south = new SouthDirection();

        Coordinate expected = new Coordinate(2, 1);
        assertThat(south.moveForward(coordinate, world)).isEqualTo(expected);
    }

    @Test
    void wrap_around_the_world_if_position_is_on_edge() {
        Coordinate coordinate = new Coordinate(2, 1);
        SouthDirection south = new SouthDirection();

        Coordinate expected = new Coordinate(2, world.yUpperLimit());
        assertThat(south.moveForward(coordinate, world)).isEqualTo(expected);
    }
}

package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EastDirectionShould {

    @Test
    void change_to_north_when_asked_to_move_left() {
        EastDirection east = new EastDirection();
        assertThat(east.moveLeft()).isEqualTo(new NorthDirection());
    }

    @Test
    void change_to_south_when_asked_to_move_right() {
        EastDirection east = new EastDirection();
        assertThat(east.moveRight()).isEqualTo(new SouthDirection());
    }

    @Test
    void increment_x_coordinate_when_asked_to_move_straight() {
        Coordinate coordinate = new Coordinate(2, 2);
        EastDirection east = new EastDirection();

        Coordinate expected = new Coordinate(3, 2);
        assertThat(east.moveForward(coordinate)).isEqualTo(expected);
    }
}

package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EastDirectionShould {

    @Test
    void change_to_north_when_asked_to_move_left() {
        EastDirection east = new EastDirection();
        assertThat(east.moveLeft()).isEqualTo(Direction.NORTH);
    }

    @Test
    void change_to_south_when_asked_to_move_right() {
        EastDirection east = new EastDirection();
        assertThat(east.moveRight()).isEqualTo(Direction.SOUTH);
    }
}

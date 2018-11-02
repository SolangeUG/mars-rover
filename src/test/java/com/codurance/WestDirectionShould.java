package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WestDirectionShould {

    @Test
    void return_south_when_asked_to_turn_left() {
        WestDirection west = new WestDirection();
        assertThat(west.moveLeft()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void return_north_when_asked_to_move_right() {
        WestDirection west = new WestDirection();
        assertThat(west.moveRight()).isEqualTo(Direction.NORTH);
    }
}

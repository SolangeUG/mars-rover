package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SouthDirectionShould {

    @Test
    void change_to_west_when_asked_to_move_right() {
        SouthDirection south = new SouthDirection();
        assertThat(south.moveRight()).isEqualTo(Direction.WEST);
    }

    @Test
    void change_to_east_when_asked_to_move_left() {
        SouthDirection south = new SouthDirection();
        assertThat(south.moveLeft()).isEqualTo(Direction.EAST);
    }
}

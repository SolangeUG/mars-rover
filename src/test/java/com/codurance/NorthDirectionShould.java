package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NorthDirectionShould {

    @Test
    void change_to_east_when_asked_to_move_right() {
        Direction north = new NorthDirection();
        assertThat(north.moveRight()).isEqualTo(new EastDirection());
    }

    @Test
    void change_to_west_when_asked_to_move_right() {
        Direction north = new NorthDirection();
        assertThat(north.moveLeft()).isEqualTo(new WestDirection());
    }
}

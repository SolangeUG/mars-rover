package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionShould {

    @Test
    void move_right_following_compass_expectations() {
        Direction direction = new NorthDirection();
        Direction expectedDirection = new EastDirection();
        Direction actualDirection = direction.moveRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new EastDirection();
        expectedDirection = new SouthDirection();
        actualDirection = direction.moveRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new SouthDirection();
        expectedDirection = new WestDirection();
        actualDirection = direction.moveRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new WestDirection();
        expectedDirection = new NorthDirection();
        actualDirection = direction.moveRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);
    }

    @Test
    void move_left_following_compass_expectations() {
        Direction direction = new NorthDirection();
        Direction expectedDirection = new WestDirection();
        Direction actualDirection = direction.moveLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new WestDirection();
        expectedDirection = new SouthDirection();
        actualDirection = direction.moveLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new SouthDirection();
        expectedDirection = new EastDirection();
        actualDirection = direction.moveLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new EastDirection();
        expectedDirection = new NorthDirection();
        actualDirection = direction.moveLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);
    }
}

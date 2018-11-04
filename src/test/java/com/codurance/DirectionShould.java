package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionShould {

    @Test
    void move_right_following_compass_expectations() {
        Direction direction = new NorthDirection();
        Direction expectedDirection = new EastDirection();
        Direction actualDirection = direction.turnRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new EastDirection();
        expectedDirection = new SouthDirection();
        actualDirection = direction.turnRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new SouthDirection();
        expectedDirection = new WestDirection();
        actualDirection = direction.turnRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new WestDirection();
        expectedDirection = new NorthDirection();
        actualDirection = direction.turnRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);
    }

    @Test
    void move_left_following_compass_expectations() {
        Direction direction = new NorthDirection();
        Direction expectedDirection = new WestDirection();
        Direction actualDirection = direction.turnLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new WestDirection();
        expectedDirection = new SouthDirection();
        actualDirection = direction.turnLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new SouthDirection();
        expectedDirection = new EastDirection();
        actualDirection = direction.turnLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);

        direction = new EastDirection();
        expectedDirection = new NorthDirection();
        actualDirection = direction.turnLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);
    }
}

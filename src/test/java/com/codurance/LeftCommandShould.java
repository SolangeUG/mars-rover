package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeftCommandShould {

    @Test
    void return_west_direction_when_rotating_north_to_the_left() {
        Direction direction = new NorthDirection();
        LeftCommand command = new LeftCommand(direction);

        Direction actual = command.execute();

        Direction expected = new WestDirection();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void return_north_direction_when_rotating_east_to_the_left() {
        Direction direction = new EastDirection();
        LeftCommand command = new LeftCommand(direction);

        Direction actual = command.execute();

        Direction expected = new NorthDirection();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void return_east_direction_when_rotating_south_to_the_left() {
        Direction direction = new SouthDirection();
        LeftCommand command = new LeftCommand(direction);

        Direction actual = command.execute();

        Direction expected = new EastDirection();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void return_south_direction_when_rotating_west_to_the_left() {
        Direction direction = new WestDirection();
        LeftCommand command = new LeftCommand(direction);

        Direction actual = command.execute();

        Direction expected = new SouthDirection();
        assertThat(actual).isEqualTo(expected);
    }
}

package com.codurance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RightCommandShould {

    @ParameterizedTest
    @CsvSource({
            "N, E",
            "E, S",
            "S, W",
            "W, N"
    })
    void return_rotated_direction_to_the_right(String initialDirection, String finalDirection) {
        Direction direction = new Direction(initialDirection);
        RightCommand command = new RightCommand(direction);

        Direction actual = command.execute();

        Direction expected = new Direction(finalDirection);
        assertThat(actual).isEqualTo(expected);
    }
}

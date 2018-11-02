package com.codurance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LeftCommandShould {

    @ParameterizedTest
    @CsvSource({
            "N, W",
            "W, S",
            "S, E",
            "E, N",
    })
    void return_rotated_direction(String initialDirection, String finalDirection) {
        Direction direction = new Direction(initialDirection);
        LeftCommand command = new LeftCommand(direction);

        command.execute();

        Direction expected = new Direction(finalDirection);
        assertThat(command.isDirection(expected)).isTrue();
    }
}

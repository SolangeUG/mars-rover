package com.codurance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionShould {

    @ParameterizedTest
    @CsvSource(
            {"N,  E",
            "E, S",
            "S, W",
            "W, N"})
    public void move_right_following_compass_expectations(String startingDirection, String finalDirection) {
        Direction direction = new Direction(startingDirection);
        Direction expectedDirection = new Direction(finalDirection);
        Direction actualDirection = direction.turnRight();

        assertThat(actualDirection).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @CsvSource(
            {"N, W",
            "W, S",
            "S, E",
            "E, N"})
    public void move_left_following_compass_expectations(String startingDirection, String finalDirection) {
        Direction direction = new Direction(startingDirection);
        Direction expectedDirection = new Direction(finalDirection);
        Direction actualDirection = direction.turnLeft();

        assertThat(actualDirection).isEqualTo(expectedDirection);
    }
}

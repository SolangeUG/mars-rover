package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverAppShould {

    @ParameterizedTest
    @CsvSource({
            "'5 5\n1 2 N\nLMLMLMLMM', 5, 5",
            "'2 4\n1 2 N\nLMLMLMLMM', 2, 4",
            "'4 4\n1 2 N\nLMLMLMLMM', 4, 4",
            "'6 8\n1 2 N\nLMLMLMLMM', 6, 8",
            "'1 4\n1 2 N\nLMLMLMLMM', 1, 4",
    })
    void parse_input_first_line_as_upper_right_corner(String input, int xUpperLimit, int yUpperLimit) {
        MarsRoverApp application = new MarsRoverApp(input);
        World world = new World(xUpperLimit, yUpperLimit);
        assertThat(application.isWorld(world)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "'5 5\n1 2 N\nLMLMLMLMM', 1",
            "'2 4\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM', 2",
            "'4 4\n1 2 N\nL\n1 4 W\nRM\n2 3 S\nLMR', 3"
    })
    void create_rovers_according_to_input(String input, int roversCount) {
        MarsRoverApp application = new MarsRoverApp(input);
        assertThat(application.hasRoversCountOf(roversCount)).isTrue();
    }

    @Test
    void output_rovers_final_positions_given_input_string_as_instruction() {
        String input = String.format(
                "%s\n%s\n%s\n%s\n%s\n",
                "5 5",
                "1 2 N", "LMLMLMLMM",
                "3 3 E", "MMRMMRMRRM");
        MarsRoverApp application = new MarsRoverApp(input);
        String output = String.format("%s\n%s", "1 3 N", "5 1 E");
        assertThat(application.output()).isEqualTo(output);
    }
}

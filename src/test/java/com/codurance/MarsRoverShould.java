package com.codurance;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverShould {

    private final int xUpperLimit = 3;
    private final int yUpperLimit = 3;
    private final World world = new World(xUpperLimit, yUpperLimit);
    private final int defaultXCoordinate = 2;
    private final int defaultYCoordinate = 2;

    @Nested
    public class WhenCallingIsDirection {

        private final MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.NORTH);

        @Test
        public void return_true_if_direction_is_the_same() {
            assertThat(rover.isDirection(Direction.NORTH)).isTrue();
        }

        @Test
        public void return_false_is_direction_is_different() {
            assertThat(rover.isDirection(Direction.EAST)).isFalse();
        }
    }

    @Nested
    public class WhenMoveIsCalled {

        private final MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.EAST);

        @Test
        public void with_right_command_turn_right() {
            rover.move("R");
            assertThat(rover.isDirection(Direction.SOUTH)).isTrue();
        }

        @Test
        public void with_left_command_turn_right() {
            rover.move("L");
            assertThat(rover.isDirection(Direction.NORTH)).isTrue();
        }
    }

    @Nested
    public class WhenMoveForwardIsCalled {
        @Test
        public void with_forward_to_east_change_x_coordinate_positively() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.EAST);
            rover.move("M");
            assertThat(rover.isPosition(3, 2)).isTrue();
        }

        @Test
        public void with_forward_to_west_change_x_coordinate_negatively() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.WEST);
            rover.move("M");
            assertThat(rover.isPosition(1, 2)).isTrue();
        }

        @Test
        public void with_forward_to_north_change_y_coordinate_positively() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.NORTH);
            rover.move("M");
            assertThat(rover.isPosition(2, 3)).isTrue();
        }

        @Test
        public void with_forward_to_south_change_y_coordinate_negatively() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.SOUTH);
            rover.move("M");
            assertThat(rover.isPosition(2, 1)).isTrue();
        }
    }

    @Nested
    public class WhenMoveForwardIsCalledOnEdges {
        @Test
        public void with_forward_to_east_change_x_coordinate_positively() {
            MarsRover rover = new MarsRover(world, new Coordinate(xUpperLimit, defaultYCoordinate), Direction.EAST);
            rover.move("M");
            assertThat(rover.isPosition(World.LOWER_LIMIT, 2)).isTrue();
        }

        @Test
        public void with_forward_to_west_change_x_coordinate_negatively() {
            MarsRover rover = new MarsRover(world, new Coordinate(World.LOWER_LIMIT, defaultYCoordinate), Direction.WEST);
            rover.move("M");
            assertThat(rover.isPosition(xUpperLimit, 2)).isTrue();
        }

        @Test
        public void with_forward_to_north_change_y_coordinate_positively() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, world.yUpperLimit()), Direction.NORTH);
            rover.move("M");
            assertThat(rover.isPosition(2, World.LOWER_LIMIT)).isTrue();
        }

        @Test
        public void with_forward_to_south_change_y_coordinate_negatively() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, World.LOWER_LIMIT), Direction.SOUTH);
            rover.move("M");
            assertThat(rover.isPosition(2, world.yUpperLimit())).isTrue();
        }
    }
    @Nested
    public class WhenCallingIsPosition {
        @Test
        public void return_true_if_positions_is_the_same() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.SOUTH);
            assertThat(rover.isPosition(2, 2)).isTrue();
        }

        @ParameterizedTest
        @CsvSource({
                "2, 3",
                "3, 2",
                "3, 3"})
        public void return_false_if_positions_is_different(int xPosition, int yPosition) {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), Direction.SOUTH);
            assertThat(rover.isPosition(xPosition, yPosition)).isFalse();
        }
    }
}

package com.codurance;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverShould {

    private final int xUpperLimit = 3;
    private final int yUpperLimit = 3;
    private final World world = new World(xUpperLimit, yUpperLimit);
    private final int defaultXCoordinate = 2;
    private final int defaultYCoordinate = 2;

    private final Direction NORTH = new NorthDirection();
    private final Direction EAST = new EastDirection();
    private final Direction SOUTH = new SouthDirection();
    private final Direction WEST = new WestDirection();

    @Nested
    class WhenCallingIsDirection {

        private final Coordinate coordinate = new Coordinate(defaultXCoordinate, defaultYCoordinate);
        private final MarsRover rover = new MarsRover(world, coordinate, NORTH);

        @Test
        void return_true_if_direction_is_the_same() {
            assertThat(rover.isDirection(NORTH)).isTrue();
        }

        @Test
        void return_false_is_direction_is_different() {
            assertThat(rover.isDirection(EAST)).isFalse();
        }
    }

    @Nested
    class WhenRotateIsCalled {

        private final Coordinate coordinate = new Coordinate(defaultXCoordinate, defaultYCoordinate);
        private final MarsRover rover = new MarsRover(world, coordinate, EAST);

        @Test
        void with_right_command_turn_right() {
            Command command = new RightCommand();
            rover.move(Collections.singletonList(command));
            assertThat(rover.isDirection(SOUTH)).isTrue();
        }

        @Test
        void with_left_command_turn_left() {
            Command command = new LeftCommand();
            rover.move(Collections.singletonList(command));
            assertThat(rover.isDirection(NORTH)).isTrue();
        }
    }

    @Nested
    class WhenMoveForwardIsCalled {

        private Coordinate coordinate = new Coordinate(defaultXCoordinate, defaultYCoordinate);

        @Test
        void with_forward_to_east_command_change_x_coordinate_positively() {
            Position position = new Position(world, coordinate, EAST);
            MarsRover rover = new MarsRover(world, coordinate, EAST);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(3, 2)).isTrue();
        }

        @Test
        void with_forward_to_west_command_change_x_coordinate_negatively() {
            Position position = new Position(world, coordinate, WEST);
            MarsRover rover = new MarsRover(world, coordinate, WEST);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(1, 2)).isTrue();
        }

        @Test
        void with_forward_to_north_command_change_y_coordinate_positively() {
            Position position = new Position(world, coordinate, NORTH);
            MarsRover rover = new MarsRover(world, coordinate, NORTH);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(2, 3)).isTrue();
        }

        @Test
        void with_forward_to_south_command_change_y_coordinate_negatively() {
            Position position = new Position(world, coordinate, SOUTH);
            MarsRover rover = new MarsRover(world, coordinate, SOUTH);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(2, 1)).isTrue();
        }
    }

    @Nested
    class WhenMoveForwardIsCalledOnEdges {

        @Test
        void with_forward_to_east_command_wrap_x_coordinate_around_the_world() {
            Coordinate coordinate = new Coordinate(xUpperLimit, defaultYCoordinate);
            Position position = new Position(world, coordinate, EAST);
            MarsRover rover = new MarsRover(world, coordinate, EAST);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(World.LOWER_LIMIT, 2)).isTrue();
        }

        @Test
        void with_forward_to_west_command_wrap_x_coordinate_around_the_world() {
            Coordinate coordinate = new Coordinate(World.LOWER_LIMIT, defaultYCoordinate);
            Position position = new Position(world, coordinate, WEST);
            MarsRover rover = new MarsRover(world, coordinate, WEST);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(xUpperLimit, 2)).isTrue();
        }

        @Test
        void with_forward_to_north_command_wrap_y_around_the_world() {
            Coordinate coordinate = new Coordinate(defaultXCoordinate, world.yUpperLimit());
            Position position = new Position(world, coordinate, NORTH);
            MarsRover rover = new MarsRover(world, coordinate, NORTH);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(2, World.LOWER_LIMIT)).isTrue();
        }

        @Test
        void with_forward_to_south_command_wrap_y_coordinate_around_the_world() {
            Coordinate coordinate = new Coordinate(defaultXCoordinate, World.LOWER_LIMIT);
            Position position = new Position(world, coordinate, SOUTH);
            MarsRover rover = new MarsRover(world, coordinate, SOUTH);
            Command command = new MoveCommand(position);

            rover.move(Collections.singletonList(command));

            assertThat(rover.isPosition(2, world.yUpperLimit())).isTrue();
        }
    }

    @Nested
    class WhenCallingIsPosition {

        @Test
        void return_true_if_positions_is_the_same() {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), SOUTH);
            assertThat(rover.isPosition(2, 2)).isTrue();
        }

        @ParameterizedTest
        @CsvSource({
                "2, 3",
                "3, 2",
                "3, 3"})
        void return_false_if_positions_is_different(int xPosition, int yPosition) {
            MarsRover rover = new MarsRover(world, new Coordinate(defaultXCoordinate, defaultYCoordinate), SOUTH);
            assertThat(rover.isPosition(xPosition, yPosition)).isFalse();
        }
    }
}

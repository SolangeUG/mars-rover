package com.codurance;

import java.util.ArrayList;
import java.util.List;

class MarsRoverApp {

    private World world;
    private List<MarsRover> rovers = new ArrayList<>();

    MarsRoverApp(String input) {
        parse(input);
    }

    String output() {
        StringBuffer result = new StringBuffer();
        rovers.forEach(rover -> result.append(String.format("%s\n", rover.output())));
        return result.toString().trim();
    }

    Boolean hasRoversCountOf(int roversCount) {
        return roversCount == rovers.size();
    }

    Boolean isWorld(World world) {
        return this.world.equals(world);
    }

    private void parse(String input) {
        String[] inputAsArray = input.split("\n");
        world = worldFrom(inputAsArray[0]);

        int i = 1;
        while(i + 1 < inputAsArray.length) {
            String position = inputAsArray[i].trim();
            String instruction = inputAsArray[i + 1].trim();
            createAndMoveRover(position, instruction);
            i += 2;
        }
    }

    private World worldFrom(String upperRightCorner) {
        String[] worldLimits = upperRightCorner.split(" ");
        return new World(Integer.valueOf(worldLimits[0]),
                         Integer.valueOf(worldLimits[1]));
    }

    private void createAndMoveRover(String positionAsString, String instruction) {
        Position initialPosition = positionFrom(positionAsString);
        List<Command> commands = commandsFrom(instruction, initialPosition);

        MarsRover rover = new MarsRover(initialPosition);
        rover.move(commands);

        rovers.add(rover);
    }

    private Position positionFrom(String positionAsString) {
        String[] parsedInput = positionAsString.split(" ");

        int xValue = Integer.valueOf(parsedInput[0]);
        int yValue = Integer.valueOf(parsedInput[1]);
        Coordinate coordinate = new Coordinate(xValue, yValue);

        Direction direction = null;
        if ("N".equals(parsedInput[2])) direction = new NorthDirection();
        if ("E".equals(parsedInput[2])) direction = new EastDirection();
        if ("S".equals(parsedInput[2])) direction = new SouthDirection();
        if ("W".equals(parsedInput[2])) direction = new WestDirection();

        return new Position(world, coordinate, direction);
    }

    private List<Command> commandsFrom(String instruction, Position initialPosition) {
        List<Command> commands = new ArrayList<>();

        for (int i = 0; i < instruction.trim().length(); i++) {
            char character = instruction.charAt(i);
            if ('L' == character) commands.add(new LeftCommand());
            if ('R' == character) commands.add(new RightCommand());
            if ('M' == character) commands.add(new MoveCommand(initialPosition));
        }

        return commands;
    }
}

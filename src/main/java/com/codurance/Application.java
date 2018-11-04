package com.codurance;

public class Application {

    public static void main(String[] args ) {
        String input = String.format(
                "%s\n%s\n%s\n%s\n%s\n",
                "5 5",
                "1 2 N", "LMLMLMLMM",
                "3 3 E", "MMRMMRMRRM");
        MarsRoverApp application = new MarsRoverApp(input);
        System.out.println(String.format("INPUT:\n%s", input));
        System.out.println(String.format("OUTPUT:\n%s", application.output()));
    }
}

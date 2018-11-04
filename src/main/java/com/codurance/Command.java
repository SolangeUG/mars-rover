package com.codurance;

public interface Command {

    Object execute();

    void updatePosition(Position position);
}

package com.example.components;

public class Transition {
    private State currentState;
    private char readSymbol;
    private char writeSymbol;
    private State nextState;
    private Direction direction;

    public Transition(State currentState, char readSymbol, char writeSymbol, 
                      State nextState, Direction direction) {
        this.currentState = currentState;
        this.readSymbol = readSymbol;
        this.writeSymbol = writeSymbol;
        this.nextState = nextState;
        this.direction = direction;
    }

    public State getCurrentState() {
        return currentState;
    }

    public char getReadSymbol() {
        return readSymbol;
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public State getNextState() {
        return nextState;
    }

    public Direction getDirection() {
        return direction;
    }
}

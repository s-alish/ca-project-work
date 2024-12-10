package com.example.config;

public class TransitionConfig {
    private String currentState;
    private char readSymbol;
    private char writeSymbol;
    private String nextState;
    private String direction;

    // Getters and setters
    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public char getReadSymbol() {
        return readSymbol;
    }

    public void setReadSymbol(char readSymbol) {
        this.readSymbol = readSymbol;
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public void setWriteSymbol(char writeSymbol) {
        this.writeSymbol = writeSymbol;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

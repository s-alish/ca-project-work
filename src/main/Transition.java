package src.main;

public class Transition {
    private State currentState;
    private char readSymbol;
    private char writeSymbol;
    private State nextState;
    private boolean moveRight;

    public Transition(State currentState, char readSymbol, char writeSymbol, 
                      State nextState, boolean moveRight) {
        this.currentState = currentState;
        this.readSymbol = readSymbol;
        this.writeSymbol = writeSymbol;
        this.nextState = nextState;
        this.moveRight = moveRight;
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

    public boolean isMoveRight() {
        return moveRight;
    }
}

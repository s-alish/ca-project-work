package src.main;

import java.util.HashMap;
import java.util.Map;

public class Tape {
    private Map<Integer, Character> tape = new HashMap<>();
    private int headPosition = 0;

    public char read() {
        return tape.getOrDefault(headPosition, ' '); // Return space if empty
    }

    public void write(char symbol) {
        tape.put(headPosition, symbol); // Write symbol at head position
    }

    public void moveLeft() {
        headPosition--; // Move head left
    }

    public void moveRight() {
        headPosition++; // Move head right
    }

    public int getHeadPosition() {
        return headPosition;
    }
}

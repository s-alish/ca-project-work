package com.example.components;

public class Head {
    private Tape tape;

    public Head(Tape tape) {
        this.tape = tape;
    }

    public char read() {
        return tape.read();
    }

    public void write(char symbol) {
        tape.write(symbol);
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            tape.moveLeft();
        } else {
            tape.moveRight();
        }
    }
}


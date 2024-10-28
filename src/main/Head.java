package src.main;

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

    public void moveLeft() {
        tape.moveLeft();
    }

    public void moveRight() {
        tape.moveRight();
    }
}

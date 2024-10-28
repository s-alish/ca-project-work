package src.main;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        Tape tape = new Tape();
        tape.write('1'); tape.moveRight();
        tape.write('0'); tape.moveRight();
        tape.write('1');

        State q0 = new State("q0");
        State q1 = new State("q1");
        State qAccept = new State("Accept");

        Transition t1 = new Transition(q0, '1', '0', q1, true);
        Transition t2 = new Transition(q1, '0', '1', qAccept, true);

        TuringMachine machine = new TuringMachine(tape, Arrays.asList(t1, t2));
        machine.setInitialState(q0);
        machine.execute();
    }
}

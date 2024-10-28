package src.main;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TuringMachine {
    private Tape tape;
    private Head head;
    private State currentState;
    private Map<String, List<Transition>> transitionTable;

    public TuringMachine(Tape tape, List<Transition> transitions) {
        this.tape = tape;
        this.head = new Head(tape);
        this.transitionTable = new HashMap<>();

        for (Transition t : transitions) {
            transitionTable.computeIfAbsent(t.getCurrentState().getName(), 
                k -> new java.util.ArrayList<>()).add(t);
        }
    }

    public void setInitialState(State initialState) {
        this.currentState = initialState;
    }

    public void execute() {
        while (true) {
            char symbol = head.read();
            List<Transition> transitions = transitionTable.get(currentState.getName());

            boolean found = false;
            for (Transition t : transitions) {
                if (t.getReadSymbol() == symbol) {
                    head.write(t.getWriteSymbol());
                    currentState = t.getNextState();
                    if (t.isMoveRight()) head.moveRight(); else head.moveLeft();
                    found = true;
                    break;
                }
            }

            if (!found) break; // Stop if no valid transition found
        }
    }
}
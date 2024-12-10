package com.example.machine;

import com.example.components.Direction;
import com.example.components.Head;
import com.example.components.State;
import com.example.components.Tape;
import com.example.components.Transition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TuringMachine {
    private Tape tape;
    private Head head;
    private State currentState;
    private Map<String, Map<Character, Transition>> transitionTable;

    public TuringMachine(Tape tape, List<Transition> transitions) {
        this.tape = tape;
        this.head = new Head(tape);
        this.transitionTable = new HashMap<>();

        // transition table filling
        for (Transition t : transitions) {
            transitionTable
                    .computeIfAbsent(t.getCurrentState().getName(), k -> new HashMap<>())
                    .put(t.getReadSymbol(), t);
        }
    }

    public void setInitialState(State initialState) {
        this.currentState = initialState;
    }

    public void execute() {
        while (true) {
            char symbol = head.read();
            Map<Character, Transition> transitions = transitionTable.get(currentState.getName());

            if (transitions == null || !transitions.containsKey(symbol)) {
                break; // stop if no transition
            }

            Transition transition = transitions.get(symbol);

            head.write(transition.getWriteSymbol());
            currentState = transition.getNextState();
            head.move(transition.getDirection());

            System.out.println("State: " + currentState + ", Tape: " + tape);
        }
    }

    public String getTape() {
        return tape.toString();
    }
}

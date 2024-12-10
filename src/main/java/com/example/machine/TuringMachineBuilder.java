package com.example.machine;

import java.util.ArrayList;
import java.util.List;

import com.example.components.Direction;
import com.example.components.State;
import com.example.components.Transition;
import com.example.components.Tape;
import com.example.config.Configuration;
import com.example.config.TransitionConfig;

public class TuringMachineBuilder {
    public static TuringMachine buildFromConfig(Configuration config) {
        // tape
        Tape tape = new Tape();
        tape.initialize(config.getTape());

        // states
        List<State> states = new ArrayList<>();
        for (String stateName : config.getStates()) {
            states.add(new State(stateName));
        }

        // transitions
        List<Transition> transitions = new ArrayList<>();
        for (TransitionConfig tConfig : config.getTransitions()) {
            State currentState = findStateByName(states, tConfig.getCurrentState());
            State nextState = findStateByName(states, tConfig.getNextState());
            Direction direction = Direction.valueOf(tConfig.getDirection().toUpperCase());
            transitions.add(new Transition(
                    currentState,
                    tConfig.getReadSymbol(), // символ на ленте как char
                    tConfig.getWriteSymbol(), // символ на ленте как char
                    nextState,
                    direction
            ));
        }

        // initial state
        State initialState = findStateByName(states, config.getInitialState());

        TuringMachine machine = new TuringMachine(tape, transitions);
        machine.setInitialState(initialState);
        return machine;
    }

    private static State findStateByName(List<State> states, String name) {
        return states.stream()
                .filter(state -> state.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("State not found: " + name));
    }
}

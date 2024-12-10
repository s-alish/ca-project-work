package com.example.config;

import java.util.List;

public class Configuration {
    private String tape;
    private List<String> states;
    private List<TransitionConfig> transitions;
    private String initialState;

    // Getters and setters
    public String getTape() {
        return tape;
    }

    public void setTape(String tape) {
        this.tape = tape;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<TransitionConfig> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<TransitionConfig> transitions) {
        this.transitions = transitions;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }
}


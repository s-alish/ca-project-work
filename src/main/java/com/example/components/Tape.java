package com.example.components;

import java.util.HashMap;
import java.util.Map;
public class Tape {
    private Map<Integer, Character> tape = new HashMap<>();
    private int headPosition = 0;

    public char read() {
        return tape.getOrDefault(headPosition, '_'); // '_' - пустой символ
    }

    public void write(char symbol) {
        tape.put(headPosition, symbol); // Записываем символ в текущую позицию
    }

    public void moveLeft() {
        headPosition--;
    }

    public void moveRight() {
        headPosition++;
    }

    public void initialize(String input) {
        tape.clear(); // Очистить текущую ленту
        for (int i = 0; i < input.length(); i++) {
            tape.put(i, input.charAt(i));
        }
        headPosition = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int min = tape.keySet().stream().min(Integer::compareTo).orElse(0);
        int max = tape.keySet().stream().max(Integer::compareTo).orElse(0);

        for (int i = min; i <= max; i++) {
            sb.append(tape.getOrDefault(i, '_'));
        }
        return sb.toString();
    }
}


# ca-project-work
**Theme**: Implementation of Turing Machine in Java

---

## Project Proposal: Design and Implementation of a Turing Machine in Java
1. **Project Topic**
The Turing machine, as a theoretical model, simulates the logic of any computer algorithm and forms the foundation of modern computational theory. The project will focus on implementing basic operations of the Turing machine, such as state transitions, tape movements, and symbol writing, using object-oriented programming principles.

2. **Importance of the Topic**
The Turing machine is one of the most influential concepts in computer science and lays the foundation for understanding computability and computational limits. By implementing a Turing machine in Java, the project provides hands-on experience with the mechanics of theoretical computing devices, bridging the gap between abstract computational theory and practical software development. 

3. **Implementation Methods**
- Architecture: The Java-based Turing machine will consist of the following components:
    - Tape: An array or list representing an infinite sequence of symbols, which the Turing machine reads from and writes to.
    - Head: A pointer that moves left or right on the tape, modifying symbols as per the transition function.
    - State Transitions: A finite set of states with transition rules that define the machine’s next state based on the current state and the symbol under the head.
    - Input: The machine will accept a string of symbols as input and manipulate the tape according to predefined rules.

- Design Approach:
  -	Object-oriented principles will be applied to encapsulate the behavior of the tape, head, and transition states.
  - A graphical user interface (GUI) will be considered to visualize the tape and the state changes.
  - An emphasis will be placed on developing efficient data structures and algorithms for representing and processing the infinite tape and transition functions.
- Evaluation:
  The Turing machine will be evaluated by testing it with various inputs that correspond to standard computational problems, such as palindrome detection, binary addition, and other basic tasks. The performance and correctness of the machine will be evaluated by comparing the results to known theoretical outcomes of Turing machines.

4. References
-	Alan M. Turing. On Computable Numbers, with an Application to the Entscheidungsproblem. Proceedings of the London Mathematical Society, 1936.

---

# Progress Report

## 1. Abstract
This report presents the design and implementation of key components for a Turing Machine project using Java. The machine consists of four core elements: **Tape**, **Head**, **State**, and **Transition** classes. The goal is to simulate a Turing Machine that performs computational tasks through state-based transitions. 

### Key Features:
- **Reading, writing, and head movements** along an infinite tape.
- **Challenges:** Handling infinite tape and debugging state transitions.
- **Solutions:** Key bug fixes and performance optimizations ensure efficient operation.
- **Future work:** Testing complex input cases and refining the implementation.

---

## 2. Design Progress
The Turing Machine consists of the following core components:

- **Tape:** Holds symbols and simulates the infinite tape.
- **Head:** Reads and writes on the tape, moving left or right.
- **State:** Represents the machine's current state.
- **Transition:** Defines rules for transitions between states.

### System Architecture
- **Tape:** Implemented using a dynamically resizable `HashMap` to simulate infinite tape.
- **Head:** Manages reading, writing, and movement on the tape.
- **State & Transition:** Control state transitions based on input.

---

## 3. Code Implementation

### `Tape` Class
```java
import java.util.HashMap;
import java.util.Map;

public class Tape {
    private Map<Integer, Character> tape = new HashMap<>();
    private int headPosition = 0;

    public char read() {
        return tape.getOrDefault(headPosition, ' ');
    }

    public void write(char symbol) {
        tape.put(headPosition, symbol);
    }

    public void moveLeft() {
        headPosition--;
    }

    public void moveRight() {
        headPosition++;
    }

    public int getHeadPosition() {
        return headPosition;
    }
}
```

### `Head` Class
```java
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
```

### `State` Class
```java
public class State {
    private String name;

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

### `Transition` Class
```java
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
```

### `TuringMachine` Class
```java
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
```

---

## 4. Problems Faced and Solutions
1. **Handling Infinite Tape:**  
   - **Problem:** Managing tape expansion to both negative and positive indices.  
   - **Solution:** Used a `HashMap` for dynamic resizing.  

2. **Head Pointer Out of Bounds:**  
   - **Problem:** Head pointer moved beyond defined tape boundaries.  
   - **Solution:** Added logic to extend the tape dynamically.

3. **Incorrect State Transitions:**  
   - **Problem:** State transitions didn't align with input symbols.  
   - **Solution:** Debugged and fixed transition logic.

---

## 5. Bug Fixes and Performance Enhancements
- **Bug Fix 1:** Fixed incorrect head movement logic.
- **Bug Fix 2:** Resolved issue with reading empty cells (defaulted to `' '`).
- **Performance:** Optimized state lookup by organizing transitions with a `HashMap`.

---

## 6. Next Steps
- Complete integration of all components.
- Implement a user interface (CLI/GUI) for better interaction.
- Test the machine with complex inputs (e.g., binary addition, palindrome detection).
- Finalize documentation and prepare for submission.

---

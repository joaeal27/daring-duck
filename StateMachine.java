import java.util.HashMap;
import java.util.Map;
public class StateMachine {
    //A StateMachine class that holds all of the states, keeps track of what the current state is, 
    // and given an input, moves to the next state and tells the tape to move left and right.

    private final Map<String, State> states;
    private State currentState;

    public StateMachine() {
        states = new HashMap<>();
    }

    /** Register a state. */
    public void addState(State s) {
        states.put(s.getName(), s);
    }

    /** Set the starting state by name. */
    public void setStartState(String name) {
        currentState = getState(name);
    }

    /** Retrieve a state by name (throws if not found). */
    public State getState(String name) {
        State s = states.get(name);
        return s;
    }

    /**
     * Execute one step on the given tape.
     * Returns true if the machine should keep running, false if it has halted.
     * Throws RuntimeException if no transition is defined (machine crashes).
     */
    public boolean step(Tape tape) {
        if (currentState.isHalt()) return false;

        char symbol = tape.read();
        Transition t = currentState.getTransition(symbol);

        // Write, move, transition
        tape.write(t.writeSymbol);
        if (t.direction == 'L') 
            tape.moveLeft();
        else                     
            tape.moveRight();

        currentState = getState(t.nextState);
        return !currentState.isHalt();
    }

    public State getCurrentState() { 
        return currentState; 
    }

    public int stateCount() { 
        return states.size(); 
    }
}

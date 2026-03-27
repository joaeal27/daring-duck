import java.util.HashMap;
import java.util.Map;

public class State {
    //A State class that holds a name, various Transitions, and knows whether or not it is a terminal state

    private final String name;
    private final boolean isHalt;
    private final Map<Character, Transition> transitions;

    public State(String name, boolean isHalt) {
        this.name        = name;
        this.isHalt      = isHalt;
        this.transitions = new HashMap<>();
    }

    /** Add a transition for the given read symbol. */
    public void addTransition(Transition t) {
        transitions.put(t.readSymbol, t);
    }

    //getting transitions from the current symbol
    public Transition getTransition(char symbol) {
        return transitions.get(symbol);
    }

    public String getName(){ 
        return name; 
    }
    public boolean isHalt(){ 
        return isHalt; 
    }

    public String toString() {
        return name + (isHalt ? " [HALT]" : "");
    }
}

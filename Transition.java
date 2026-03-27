public class Transition {
    // A Transition class that keeps track of:
    // tape input symbol as input, what state to move to next, what to write, and whether to move the tape left or right.

    public final char readSymbol;   
    public final char writeSymbol; 
    public final char direction;    
    public final String nextState;  

    public Transition(char readSymbol, char writeSymbol, char direction, String nextState) {
        this.readSymbol  = readSymbol;
        this.writeSymbol = writeSymbol;
        this.direction   = direction;
        this.nextState   = nextState;
    }

    public String toString() {
        return "read= " + readSymbol + "write= " + writeSymbol +  "move= " + direction + " next= " + nextState;
    }
}

import java.util.ArrayList;

public class Tape {
    //receives a starting input in its constructor, and can go left, right, read, and write. 
    //The Tape class should automatically resize when it discovers that more tape is needed. 
    // It should also have some sort of toString() or oneCount() method so that we can all see the output when the machine is done running!

    private ArrayList<Character> tape;
    private int head;       // index in the ArrayList where the head currently is
    private int offset;     // how far left we've extended (to handle negative indices)

    public static final char BLANK = '0'; // '0' is our blank/null symbol

    public Tape(String input) {
        tape = new ArrayList<>();
        offset = 0;
        // Load the input onto the tape
        for (char c : input.toCharArray()) {
            tape.add(c);
        }

        // If empty input, start with a blank
        if (tape.isEmpty()) {
            tape.add(BLANK);
        }
        head = 0;
    }

    //wherever the tape is currently pointing
    public char read() {
        return tape.get(head);
    }

    public void write(char symbol) {
        tape.set(head, symbol);
    }

    // Move the head left, extending tape if necessary.
    public void moveLeft() {
        if (head == 0) {
            tape.add(0, BLANK); //places blank 
            offset++;
            // head stays at 0 after insert — that's the new leftmost cell
        } else {
            head--;
        }
    }

    /** Move the head right, extending tape if necessary. */
    public void moveRight() {
        head++;
        if (head >= tape.size()) {
            tape.add(BLANK);
        }
    }

    //counting 1's on the tapw
    public int oneCount() {
        int count = 0;
        for (char c : tape) {
            if (c == '1') 
                count++;
        }
        return count;
    }

    /** Return a string representation of the tape (trims leading/trailing blanks). */
    public String toString() {
        int start = 0;
        int end = tape.size() - 1;
        // Trim leading blanks
        while (start < end && tape.get(start) == BLANK) start++;
        // Trim trailing blanks
        while (end > start && tape.get(end) == BLANK) end--;

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(tape.get(i));
        }
        return sb.length() == 0 ? "[blank tape]" : sb.toString();
    }
}

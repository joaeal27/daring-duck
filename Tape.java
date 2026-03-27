import java.util.HashMap;

public class Tape {
    private String startingInput;
    private HashMap<Integer, Character> tape = new HashMap<>();
    private int head = 0;
    private final char empty = '_';
    //receives a starting input in its constructor, and can go left, right, read, and write. 
    //The Tape class should automatically resize when it discovers that more tape is needed. 
    // It should also have some sort of toString() or oneCount() method so that we can all see the output when the machine is done running!
    
    // 15/ (s + a +)
    //reccomend: 0, 1, 2 alphabet
    //see a 2, replace a 1 then write 2 1's at the end

    //tape will be an array list, allows you to read, write edit
    public Tape(String startingInput){
        this.startingInput = startingInput;
    }

    public void right(){
        
        }
    }

    public int oneCount()




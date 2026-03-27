public class TuringMachineRunner {
    //A TuringMachineRunner class that has main, manually assembles your chosen machine, runs the Turing Machine, checks whether each new state is a final state, and does something reasonable with the output when the final state is reached.

    public static void main(String[] args) {

        //building tape of cardinality 0
        String input = "";
        Tape tape = new Tape(input);

        State A    = new State("A", false);
        State B    = new State("B", false);
        State C    = new State("C", false);
        State D    = new State("D", false);
        State E    = new State("E", false);
        State HALT = new State("HALT", true);

        
        //adding transitions
        // State A
        A.addTransition(new Transition('0', '1', 'R', "B"));
        A.addTransition(new Transition('1', '1', 'L', "C"));

        // State B
        B.addTransition(new Transition('0', '1', 'R', "C"));
        B.addTransition(new Transition('1', '1', 'R', "B"));

        // State C
        C.addTransition(new Transition('0', '1', 'R', "D"));
        C.addTransition(new Transition('1', '0', 'L', "E"));

        // State D
        D.addTransition(new Transition('0', '1', 'L', "A"));
        D.addTransition(new Transition('1', '1', 'L', "D"));

        // State E
        E.addTransition(new Transition('0', '1', 'R', "HALT"));
        E.addTransition(new Transition('1', '0', 'L', "A"));

        // halt does not transitio

        //creating state machine
        StateMachine sm = new StateMachine();
        sm.addState(A);
        sm.addState(B);
        sm.addState(C);
        sm.addState(D);
        sm.addState(E);
        sm.addState(HALT);
        sm.setStartState("A");

        
        System.out.println("Starting state : A");
        System.out.println("Input tape     : (empty)");
        System.out.println("Running...\n");

        int steps = 0;

        while (sm.step(tape)) {
            steps++;
        }

        //reporting score  
        System.out.println("Total steps             : " + steps);
        System.out.println("Number of states  |S|   : " + sm.stateCount());
        System.out.println("Alphabet size     |Γ|   : " + 2);
        System.out.println("Input length    |t_in|  : " + input.length());
        System.out.println("Ones on tape      O     : " + tape.oneCount());
        System.out.println();

        // Print the final tape
        System.out.println("Final tape:");
        System.out.println(tape.toString());
    }
}

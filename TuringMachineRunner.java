public class TuringMachineRunner {
    //A TuringMachineRunner class that has main, manually assembles your chosen machine, runs the Turing Machine, checks whether each new state is a final state, and does something reasonable with the output when the final state is reached.

    public static void main(String[] args) {

        //building tape of cardinality 0
        String input = "";
        Tape tape = new Tape(input);

        State A    = new State("A",    false);
        State B    = new State("B",    false);
        State C    = new State("C",    false);
        State D    = new State("D",    false);
        State E    = new State("E",    false);
        State HALT = new State("HALT", true);

        // ---------------------------------------------------------------
        // 3. Add transitions
        //    new Transition(readSymbol, writeSymbol, direction, nextStateName)
        // ---------------------------------------------------------------

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

        // HALT has no transitions (it's the halt state)

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

        long steps = 0;
        long startTime = System.currentTimeMillis();

        try {
            while (sm.step(tape)) {
                steps++;
                // Optional: print progress every 1 million steps
                if (steps % 1_000_000 == 0) {
                    System.out.println("  Steps so far: " + steps
                        + "  |  Current state: " + sm.getCurrentState().getName());
                }
            }
        } catch (RuntimeException e) {
            System.err.println("Machine crashed: " + e.getMessage());
            System.exit(1);
        }

        long elapsed = System.currentTimeMillis() - startTime;

        //reporting score
        int ones       = tape.oneCount();
        int numStates  = sm.stateCount();          
        int numSymbols = 2;                        
        int inputLen   = input.length();           
        double score   = (double) ones / (numStates + numSymbols + inputLen);

        
        System.out.println("Machine halted in state : " + sm.getCurrentState().getName());
        System.out.println("Total steps             : " + steps);
        System.out.println("Elapsed time            : " + elapsed + " ms");
        System.out.println();
        System.out.println("--- Key Numbers for Submission ---");
        System.out.println("Number of states  |S|   : " + numStates);
        System.out.println("Alphabet size     |Γ|   : " + numSymbols);
        System.out.println("Input length    |t_in|  : " + inputLen);
        System.out.println("Ones on tape      O     : " + ones);
        System.out.println();
        System.out.printf( "SCORE = O / (|S|+|Γ|+|t_in|) = %d / (%d+%d+%d) = %.4f%n",
                ones, numStates, numSymbols, inputLen, score);
        System.out.println("===========================================");

        // Print the final tape (trimmed)
        System.out.println("\nFinal tape (trimmed, first 200 chars):");
        String tapeStr = tape.toString();
        if (tapeStr.length() > 200) {
            System.out.println(tapeStr.substring(0, 200) + "...[" + tapeStr.length() + " total chars]");
        } else {
            System.out.println(tapeStr);
        }
    }
}

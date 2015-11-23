package PushdownAutomaton;

public class PDARunState {

    //Parâmetros
    public int matchedSoFar;
    public String stack;
    public int state;
    public String input;
    public boolean failure;

    public PDARunState(String input, int matchedSoFar, String stack,
                       int state) {
        this.input = input;
        this.matchedSoFar = matchedSoFar;
        this.stack = stack;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Input: %s, Level: %d, Stack: %s, State: %d, Result: %b /",
                input, matchedSoFar, stack, state, failure);
    }

}

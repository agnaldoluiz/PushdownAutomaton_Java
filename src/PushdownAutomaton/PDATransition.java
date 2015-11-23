package PushdownAutomaton;

//Classe que representa uma transição no PDA
public class PDATransition {

    //Parâmetros
    public Character inputChar;
    public Character stackHead;
    public String stackReplace;
    public int oldState;
    public int newState;

    //Construtor
    public PDATransition(Character inputChar, Character stackHead, int oldState,
                         int newState, String stackReplace)
    {
        this.inputChar = inputChar;
        this.stackHead = stackHead;
        this.stackReplace = stackReplace;
        this.oldState = oldState;
        this.newState = newState;
    }

    //Método que recebe um estado e liga aquele estado com as possíveis transições
    public boolean matchesConfiguration(PDARunState state) {
        return inputChar == state.input.charAt(0) &&
                oldState == state.state &&
                ((stackHead == '_' && state.stack.length() == 0) ||
                        (state.stack.length() > 0 && stackHead == state.stack.charAt(0)));
    }
}

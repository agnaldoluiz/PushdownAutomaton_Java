package PushdownAutomaton;

//Classe que representa os estados da máquina. É a classe que guarda a pilha.
//Cada estado tem sua pilha
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

    //Método que printa na tela o estado
    @Override
    public String toString() {
        return String.format("Input: %s, Level: %d, Stack: %s, State: %d /",
                input, matchedSoFar, stack, state);
    }

}

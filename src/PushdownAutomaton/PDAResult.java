package PushdownAutomaton;
//Classe simples que representa resultados das transições. Importante para o sucesso da computação

public class PDAResult {

    //Parâmetros
    public int consumedLength;
    public int stackCount;
    public boolean success;

    //Construtor
    public PDAResult(int consumedLength, int stackCount, boolean success) {
        this.consumedLength = consumedLength;
        this.stackCount = stackCount;
        this.success = success;
    }
}

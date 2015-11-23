package PushdownAutomaton;

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

    @Override
    public String toString(){
        return String.format("Success: %b, Consumed: %d, Stack Size: %d",
                success, consumedLength, stackCount);
    }
}

package Testes;

//Segundo teste: PDA de parênteses
import PushdownAutomaton.PDATransition;
import PushdownAutomaton.PDA;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Test1 {
    public static void main(String [] args) {

        List<Character> alphabet = new ArrayList<Character>();
        alphabet.add('(');
        alphabet.add(')');

        List<Character> stackAlphabet = new ArrayList<Character>();
        stackAlphabet.add('(');

        HashSet<Integer> states = new HashSet<Integer>();
        //Primeiro estado: 1
        states.add(1);

        List<PDATransition> transitions = new ArrayList<PDATransition>();
        transitions.add(new PDATransition('(', '_', 1, 1, "("));
        transitions.add(new PDATransition('(', '(', 1, 1, "(("));
        transitions.add(new PDATransition(')', '(', 1, 1, ""));

        PDA pda = new PDA(alphabet, stackAlphabet, 1, states, transitions);

        System.out.println(pda.doesMatch(""));             // True
        System.out.println(pda.doesMatch("(())"));         // True
        System.out.println(pda.doesMatch("(()"));          // False
        System.out.println(pda.doesMatch("((())()(()))")); // True
    }
}

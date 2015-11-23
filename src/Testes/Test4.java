package Testes;

import PushdownAutomaton.PDA;
import PushdownAutomaton.PDATransition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test4 {

    public static void main(String [] args) {

        List<Character> alphabet = new ArrayList<Character>();
        alphabet.add('a');
        alphabet.add('b');

        List<Character> stackAlphabet = new ArrayList<Character>();
        stackAlphabet.add('0');

        HashSet<Integer> states = new HashSet<Integer>();
        states.add(1);

        List<PDATransition> transitions = new ArrayList<PDATransition>();
        transitions.add(new PDATransition('a', '_', 1, 1, "0"));
        transitions.add(new PDATransition('a', '0', 1, 1, "00"));
        transitions.add(new PDATransition('b', '0', 1, 2, ""));
        transitions.add(new PDATransition('b', '0', 2, 2, ""));
        transitions.add(new PDATransition('a', '_', 2, 2, ""));
        transitions.add(new PDATransition('a', '0', 2, 2, "0"));

        PDA pda = new PDA(alphabet, stackAlphabet, 1, states, transitions);

        System.out.println(pda.doesMatch("aba"));             // True
    }
}

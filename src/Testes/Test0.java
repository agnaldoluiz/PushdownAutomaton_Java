package Testes;

//Primeiro teste: palíndromo de 0 e 1

import PushdownAutomaton.PDATransition;
import PushdownAutomaton.PDA;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Test0 {
    public static void main(String [] args) {

        List<Character> alphabet = new ArrayList<Character>();
        alphabet.add('0');
        alphabet.add('1');

        List<Character> stackAlphabet = new ArrayList<Character>();
        stackAlphabet.add('0');

        HashSet<Integer> states = new HashSet<Integer>();
        //Primeiro estado: 1
        states.add(1);

        List<PDATransition> transitions = new ArrayList<PDATransition>();
        transitions.add(new PDATransition('0', '_', 1, 1, "0"));
        transitions.add(new PDATransition('0', '0', 1, 1, "00"));
        transitions.add(new PDATransition('1', '0', 1, 1, ""));

        PDA pda = new PDA(alphabet, stackAlphabet, 1, states, transitions);

        System.out.println(pda.doesMatch("0011"));             // True
        System.out.println(pda.doesMatch("000111"));         // True
        System.out.println(pda.doesMatch("001"));          // False
        System.out.println(pda.doesMatch("000000111111")); // True
    }
}

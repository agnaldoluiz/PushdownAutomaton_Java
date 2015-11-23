package Testes;

//Quarto teste: letra B das especificações do Lab

import PushdownAutomaton.PDA;
import PushdownAutomaton.PDATransition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test3 {
    public static void main(String [] args) {

        List<Character> alphabet = new ArrayList<Character>();
        alphabet.add('0');
        alphabet.add('1');

        List<Character> stackAlphabet = new ArrayList<Character>();
        stackAlphabet.add('0');
        stackAlphabet.add('1');

        HashSet<Integer> states = new HashSet<Integer>();
        states.add(1);

        List<PDATransition> transitions = new ArrayList<PDATransition>();
        transitions.add(new PDATransition('0', '_', 1, 1, "0"));
        transitions.add(new PDATransition('1', '_', 1, 1, "1"));
        transitions.add(new PDATransition('0', '0', 1, 1, "00"));
        transitions.add(new PDATransition('0', '1', 1, 1, "01"));
        transitions.add(new PDATransition('1', '1', 1, 1, "11"));
        transitions.add(new PDATransition('1', '0', 1, 1, "10"));
        transitions.add(new PDATransition('1', '1', 1, 2, ""));
        transitions.add(new PDATransition('1', '0', 1, 2, ""));
        transitions.add(new PDATransition('0', '0', 1, 2, ""));
        transitions.add(new PDATransition('0', '1', 1, 2, ""));
        transitions.add(new PDATransition('1', '1', 2, 2, ""));
        transitions.add(new PDATransition('1', '0', 2, 2, ""));
        transitions.add(new PDATransition('0', '0', 2, 2, ""));
        transitions.add(new PDATransition('0', '1', 2, 2, ""));




        PDA pda = new PDA(alphabet, stackAlphabet, 1, states, transitions);

        System.out.println(pda.doesMatch("000111"));             // True
        System.out.println(pda.doesMatch("0101"));              // True
        System.out.println(pda.doesMatch("0011"));        // True
        System.out.println(pda.doesMatch("0"));       // False
        System.out.println(pda.doesMatch("00011"));   //False
    }
}

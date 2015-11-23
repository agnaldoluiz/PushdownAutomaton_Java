package Testes;

//Terceiro teste: Letra A das especificações do Lab

import PushdownAutomaton.PDA;
import PushdownAutomaton.PDATransition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test2 {
    public static void main(String [] args) {

        List<Character> alphabet = new ArrayList<Character>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');

        List<Character> stackAlphabet = new ArrayList<Character>();
        stackAlphabet.add('a');

        HashSet<Integer> states = new HashSet<Integer>();
        states.add(1);

        List<PDATransition> transitions = new ArrayList<PDATransition>();
        transitions.add(new PDATransition('a', '_', 1, 1, "a"));
        transitions.add(new PDATransition('a', 'a', 1, 1, "aa"));
        transitions.add(new PDATransition('b', 'a', 1, 1, ""));
        transitions.add(new PDATransition('c', '_', 1, 1, ""));
        transitions.add(new PDATransition('b', 'a', 1, 2, "a"));
        transitions.add(new PDATransition('b', 'a', 2, 2, "a"));
        transitions.add(new PDATransition('c', 'a', 2, 2, ""));


        PDA pda = new PDA(alphabet, stackAlphabet, 1, states, transitions);

        System.out.println(pda.doesMatch("aabcc"));             // True
        System.out.println(pda.doesMatch("aabb"));              // True
        System.out.println(pda.doesMatch("aabbcccccc"));        // True
        System.out.println(pda.doesMatch("aabbbcccc"));       // False
    }
}

package PushdownAutomaton;

//Classe principal que representa o Automaton

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PDA {

    //Parâmetros de um automata
    public List<Character> alphabet;
    public List<Character> stackAlphabet;
    public int initialState;
    public HashSet<Integer> states;
    public List<PDATransition> transitions;

    //Construtor
    public PDA (List<Character> alphabet, List<Character> stackAlphabet,
                int initialState, HashSet<Integer> states, List<PDATransition> transitions) {
        this.alphabet = alphabet;
        this.stackAlphabet = stackAlphabet;
        this.initialState = initialState;
        this.states = states;
        this.transitions = transitions;
    }

    //Método principal que verifica se alguma computação funcionou
    public boolean doesMatch(String input) {
        List<PDAResult> results = matchResults(input);

        for(PDAResult result : results)
            if(result.success)
                return true;

        return false;
    }

    //Método que retorna os resultados da computação
    public List<PDAResult> matchResults(String input) {

        //Caso trivial = input é string '' retorna como true
        if (input.equals("")) {
            return new ArrayList<PDAResult>(Arrays.asList(new PDAResult(0,0,true)));
        }

        //Verifica se existe dois tipos de transition: um inicial e um que consegue popar a pilha
        //Se não houver esses dois tipos, retorna falso
        //Início da lógica
        boolean initial_transition = false;
        boolean transition_that_pops = false;
        for(PDATransition transition: transitions) {
            if(transition.stackHead == '_' && transition.oldState == initialState && transition.inputChar == input.charAt(0)) {
                initial_transition = true;
            }
            if(transition.stackReplace.length() == 0) {
                transition_that_pops = true;
            }
        }
        if(!initial_transition || !transition_that_pops) {
            return new ArrayList<PDAResult>(Arrays.asList(new PDAResult(0,0,false)));
        }
        //Fim

        //HashSet para eliminar estados duplicados
        Set<PDAResult> resultList = new HashSet<PDAResult>();

        //Lista de estados começando com o estado inicial (1)
        List<PDARunState> stateList = new ArrayList<PDARunState>(Arrays.asList(new PDARunState(input,0,"",initialState)));

        //Enquanto não houver transições possíveis..
        while (!stateList.isEmpty()) {
            //Imprime na tela a lista dos atuais estados
            System.out.println(stateList);

            //Cria um set para futuros estados de acordo com as transições
            Set<PDARunState> newStateList = new HashSet<PDARunState>();

            //Busca novos estados para cada estado da lista atual
            for (PDARunState state : stateList) {
                List<PDARunState> nextStates = findNextStates(state);

                //Não achou um próximo estado. Coloca uma falha no estado e nem continua mais o loop
                if(nextStates.isEmpty()) {
                    resultList.add(new PDAResult(state.matchedSoFar,
                            state.stack.length(), false));
                    continue;
                }

                //Verifica já se os próximos estados são válidos
                for(PDARunState nextState : nextStates) {

                    if(nextState.failure || nextState.input.equals("")
                            && nextState.stack.length() == 0) {
                        resultList.add(new PDAResult(nextState.matchedSoFar,
                                nextState.stack.length(), !nextState.failure));
                    }
                    else {
                        newStateList.add(nextState);
                    }
                }
            }
            //Recebe o HashSet em formato de lista
            stateList = new ArrayList<PDARunState>(newStateList);
        }
        
        return new ArrayList<PDAResult>(resultList);

    }

    //Retorna uma lista com os próximos possíveis estados dado o estado atual
    public List<PDARunState> findNextStates(PDARunState state) {
        List<PDARunState> followTransition = new ArrayList<PDARunState>();
        for(PDATransition transition : transitions) {
            if(transition.matchesConfiguration(state)) {
                followTransition.add(applyTransition(transition,state));
            }
        }
        return followTransition;
    }

    //Aplica a transição de estados dado um estado e uma transição
    private static PDARunState applyTransition(PDATransition transition,
                                               PDARunState state) {
        int newState = transition.newState;
        String newStack = state.stack;
        String newInput = state.input.substring(1);
        int newMatchedSoFar = state.matchedSoFar + 1;
        boolean isFailure = false;

        if(transition.stackHead != '_') {
            if(newStack.length() > 0) {
                newStack = newStack.substring(1);
            }
            else {
                isFailure = true;
            }
        }
        else if(!newStack.equals("")) {
            isFailure = true;
        }

        if(!isFailure) {
            newStack = transition.stackReplace + newStack;
        }

        PDARunState returnState = new PDARunState(newInput,newMatchedSoFar,newStack,newState);

        if(isFailure || newInput.equals("") && newStack.length() > 0 ||
                newInput.length() < newStack.length()) {
            returnState.failure = true;
        }

        return returnState;
    }
}
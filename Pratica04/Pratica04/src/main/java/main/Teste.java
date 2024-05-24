package main;

import java.util.Vector;

public class Teste {
    private static final int MAX = 10000; //varia de aordo com o tamanho da árvore que vamos montar
    private static final int ORDEM = 2; //varia de aordo com o tamanho da árvore que vamos montar
    
    public static void main (String [] args) {
        ArvoreB arvore = new ArvoreB (ORDEM);
        Item x;
        Vector<Integer> vetor = new Vector<>();
            
        for (int i = 0; i < MAX; i++)
            vetor.add(i);
        
        for (Integer i = 0; i < MAX; i++) { 
            x = new Item (vetor.get(i));
            arvore.insere (x);
        }
        
        Item teste = new Item (MAX);
        arvore.pesquisa (teste, 0); //faz a chamada para a pesquisa por um item na arvore e passa um parametro inteiro para checar o número de comparações
    }
}

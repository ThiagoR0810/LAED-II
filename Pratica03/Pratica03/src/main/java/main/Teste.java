package main;
import java.util.Vector;
import java.util.Collections;

public class Teste {
    private static final int MAX = 1000; //varia de aordo com o tamanho da árvore que vamos montar
    
    public static void main (String [] args) {
        ArvoreSBB arvore = new ArvoreSBB ();
        Item x;
        Vector<Integer> vetor = new Vector<>();
            
        for (int i = 0; i < MAX; i++)
            vetor.add(i);
        
        //Collections.shuffle(vetor); //Usada apenas para inserção de elementos desordenados
        for (Integer i = 0; i < MAX; i++) { 
            x = new Item (vetor.get(i));
            arvore.insere (x);
        }
        
        Item teste = new Item (MAX);
        teste = (Item)arvore.pesquisa (teste, 0);
    }
}

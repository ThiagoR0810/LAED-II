package Principal;


import java.util.Random;

public class Teste {
    
    private static final int MAX = 10000; //Depende do tmanho do heap que vamos criar
    //É necessário descomentar a parte a ser testada!
        
    public static void main(String[] args)
    {
        HeapSort heap = new HeapSort();
        Item[] v = new Item[MAX + 1];
        
        
        //CRESCENTE
            for(int i = 1; i <= MAX; i++)
            {
                Item aux = new Item(i);
                v[i] = aux;
            }
            heap.ordenacao(v);
            System.out.println("Comparações: " + heap.comparacoes());  
        //FIM DO CRESCENTE
        
        
        //DECRESCENTE
            /*for(int i = MAX, n = 1; i >= 1; i--, n++)
            {
                Item aux = new Item(i);
                v[n] = aux;
            }
            heap.ordenacao(v);
            System.out.println("Comparações: " + heap.comparacoes());*/
        //FIM DO DECRESCENTE
        
        
        //ALEATÓRIO
            /*Random gerador = new Random();
            for(int i = 1; i <= MAX; i++)
            {
                Item aux = new Item(gerador.nextInt(MAX));
                v[i] = aux;
            }
            heap.ordenacao(v);
            System.out.println("Comparações: " + heap.comparacoes());*/
        //FIM DO ALEATÓRIO
    }
    
}

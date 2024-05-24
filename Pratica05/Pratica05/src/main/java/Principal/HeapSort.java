
package Principal;

public class HeapSort {
    
    private Item vetorOrdenado[];
    private Heap heap;    
    
    public HeapSort() { }
    
    public Item[] ordenacao(Item v[]) //ordena o vetor chamando o construtor do heap
    {
        heap = new Heap(v);
        heap.constroi();
        vetorOrdenado = heap.getHeap();
        return this.vetorOrdenado;
    }
    
    public int comparacoes() 
    {
        return this.heap.comparacoes();
    }
    
}

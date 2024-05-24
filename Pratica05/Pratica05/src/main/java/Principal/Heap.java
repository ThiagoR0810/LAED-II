
package Principal;

public class Heap {
    
    private Item v[];
    private int n;
    private int numeroComp;

    public Heap(Item v[]) 
    { 
        this.v = v;
        this.n = this.v.length - 1;
        this.numeroComp = 0;
    }

    public void refaz(int esq, int dir) //refaz o heap atraves de comparações, chamando o método compara da classe item
    {
        int j = esq * 2;
        Item x = this.v[esq];
        while (j <= dir) 
        {
            this.numeroComp ++;
            if ((j < dir) && (this.v[j].compara(this.v[j + 1]) < 0)) 
            {
                j++;
            }
            this.numeroComp ++;
            if (x.compara(this.v[j]) >= 0) 
            {
                break;
            }
            this.v[esq] = this.v[j];
            esq = j;
            j = esq * 2;
        }
        this.v[esq] = x;
    }

    public void constroi() //constroi o heap chamando o metodo refaz
    {
        int esq = n / 2 + 1;
        while (esq > 1) 
        {
            esq--;
            this.refaz(esq, this.n);
        }
    } 

    public Item[] getHeap() 
    {
        return v;
    }

    public int comparacoes() 
    {
        return numeroComp;
    }
}

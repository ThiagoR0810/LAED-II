
package Principal;

public class XGrafo {

public static class Aresta {
        private int v1, v2;

        public Aresta (int v1, int v2) {
            this.v1 = v1; 
            this.v2 = v2;
        }
        
        public int v1 () { 
            return this.v1; 
        }
        
        public int v2 () { 
            return this.v2; 
        }
    }

    private int mat[][]; //pesos do tipo inteiro
    private int numVertices;
    private int pos[]; //posicao atual ao se percorrer os adjs de um vertice v

    public XGrafo (int numVertices) 
    {
        this.mat = new int [numVertices] [numVertices];
        this.pos = new int [numVertices]; 
        this.numVertices = numVertices; 
        for (int i = 0; i < this.numVertices; i++) 
        {
            for (int j = 0; j < this.numVertices; j++) 
                this.mat[i][j] = 0; //incializando a matriz com zero
                this.pos[i] = -1; 
        }
    }

    public XGrafo (int numVertices, int numArestas) 
    {
        this.mat = new int [numVertices] [numVertices];
        this.pos = new int [numVertices]; 
        this.numVertices = numVertices; 
        for (int i = 0; i < this.numVertices; i++) 
        {
            for (int j = 0; j < this.numVertices; j++) 
            this.mat[i][j] = 0; //incializando a matriz com zero
            this.pos[i] = -1; 
        }
    }

    public void insereAresta (int v1, int v2) {
        this.mat[v1][v2] = 1; 
    }

    public boolean existeAresta (int v1, int v2) {
        return (this.mat[v1][v2] == 1);
    }

    public boolean listaAdjVazia (int v) {
        for (int i = 0; i < this.numVertices; i++)
            if (this.mat[v][i] == 1) 
                return false;
        return true;
    }

    public Aresta primeiroListaAdj (int v) { //retorna a primeira aresta que o vértice v participa ou null se a lisa de adjacencia de v for vazia
        this.pos[v] = -1; 
        return this.proxAdj (v);
    }

    public Aresta proxAdj (int v) { //retorna a proxima aresta que o vértice v participa ou null se a lisa de adjacencia de v estiver no fim
        this.pos[v] ++;
        while ((this.pos[v] < this.numVertices) && (this.mat[v][this.pos[v]] == 0)) 
            this.pos[v] ++;
        
        if (this.pos[v] == this.numVertices) 
            return null;
        else 
            return new Aresta (v, this.pos[v]);
    }

    public Aresta retiraAresta (int v1, int v2) {
        if (this.mat[v1][v2] == 0) // se a aresta não existe 
            return null; 
        else {
            Aresta aresta = new Aresta (v1, v2);
            this.mat[v1][v2] = 0; 
            return aresta;
        }
    }

    public void imprime () {
        System.out.print ("   ");
        
        for (int i = 0; i < this.numVertices; i++) 
            System.out.print (i + "   "); 
        
        System.out.println ();
        
        for (int i = 0; i < this.numVertices; i++) { 
            System.out.print (i + "  ");

            for (int j = 0; j < this.numVertices; j++)
                System.out.print (this.mat[i][j] + "   "); 

            System.out.println ();
        }
    }

    public int numVertices () { 
        return this.numVertices; 
    }
    
}

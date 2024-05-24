
import java.util.Vector;

public class XGrafo {
    // Classe interna aresta, com os 2 vertices e o peso.
    public class Aresta {
        /*
         * V�riaveis internas
         * int v1 : Vertice da ponta 1;
         * int v2 : Vertice da ponta 2;
         * int peso : peso da aresta;
         */
    	private int verticeOrigem;
        private int verticeDestino;
        private int peso;
        
        public Aresta() {}

    	public Aresta(int origem, int destino, int peso) {
    		this.verticeOrigem = origem;
    		this.verticeDestino = destino;
    		this.peso = peso;
    	}

    	public int getVerticeOrigem() {
    		return verticeOrigem;
    	}


    	public int getVerticeDestino() {
    		return verticeDestino;
    	}

    	public int getPeso() {
    		return peso;
    	}
        
        public String toString() {
        	String str = "O = "+getVerticeOrigem()+" D = "+getVerticeDestino()+" com P = "+getPeso();
        	return str;
        }
    }
    /*
     * Vari�veis da classe XGrafo:
     * int mat[][]: Matriz de adjac�ncias, que armazena os pesos do tipo inteiro.
     * int numVertices: N�mero de v�rtices do grafo.
     * int pos[] = Arranjo com as posi��eses (posi��o atual ao se percorrer os adjs de um v�rtice v).
     */
    private int mat[][] ; 
    private int numVertices;
    private int pos[] ; 
    
    // Construtor da classe XGrafo.
    public XGrafo(int numVertices) {
        // Instancia matriz de adjacencias.
        this.mat = new int[numVertices][numVertices];
        // Instancia arranjo de posi��es.
        this.pos = new int[numVertices];
        // Iniciliza numero de vertices.
        this.numVertices = numVertices;
        // Inicializa matriz de adjacencias com 0 e posi��es com -1.
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++){ 
                this.mat[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }

    // M�todo para inser��o de aresta com peso.
    /*
     * Par�metros:
     * v1 = v�rtice 1 da aresta.
     * v2 = v�rtice 2 da aresta.
     * peso = peso da aresta (v1,v2).
     */
    public void insereAresta (int v1, int v2, int peso) {
        this.mat[v1][v2] = peso;
    }
    
    // M�todo de remo��o de aresta.
    /*
     * Par�metros:
     * v1 = v�rtice 1 da aresta.
     * v2 = v�rtice 2 da aresta.
    */
    public Aresta retiraAresta ( int v1, int v2) {
        // Verifica se aresta existe
        if (this.mat[v1] [v2] == 0){  
            // Se aresta n�o existe, retorna null.
            return null;
        }else {
            // Se existir, armazena valor numa aresta auxiliar.
            Aresta aresta = new Aresta (v1, v2, this.mat[v1][v2]);
            // Coloca 0 no lugar e retorna o auxiliar.
            this.mat[v1] [v2] = 0; return aresta;
        }
    }

    // M�todo que acessa a pr�xima aresta.
    // Par�metro : v = v�rtice desejado.
    public Aresta proxAdj (int v) {
        // Retorna a pr�xima aresta que o v�rtice v participa (como origem) ou
        // null se a lista de adjac�ncia de v estiver no fim
        this.pos[v]++;
        while (( this.pos[v] < this.numVertices) && (this.mat[v][this.pos[v]] == 0)){ 
            this.pos[v]++;
        }
        if (this.pos[v] == this.numVertices){ 
            return null;
        }else{ 
            return new Aresta(v, this.pos[v] , this.mat[v][this.pos[v]]);
        }
    }

    // M�todo que verifica exist�ncia de uma aresta entre dois v�rtices.
     /*
     * Par�metros:
     * v1 = v�rtice 1 da aresta.
     * v2 = v�rtice 2 da aresta.
     */
    public boolean existeAresta (int v1, int v2) {
        return (this.mat[v1][v2] > 0);
    }

    // M�todo que verifica se a lista de adjac�ncias de v est� vazia.
    // Par�metro : v = v�rtice desejado.
    public boolean listaAdjVazia ( int v) {
        for (int i = 0; i < this.numVertices; i++)
            // Se encontrar alguma aresta, retorna false.
            if (this.mat[v][i] > 0) return false;
        return true;
    }

    // M�todo que retorna o primeiro item da lista de adjac�ncias do v�rtice v.
    // Par�metro : v = v�rtice desejado.
    public Aresta primeiroListaAdj (int v) {
        // Retorna a primeira aresta que o v�rtice v participa ou
        // null se a lista de adjac�ncia de v for vazia
        this.pos[v] = -1; 
        return this.proxAdj(v);
    }

    // M�todo que imprime o grafo, no formato da matriz de adjac�ncias.
    public void imprime () {
        System.out.print("  ");
        for (int i = 0; i < this.numVertices; i++)
        System.out.print(i + " ");
        System.out.println() ;
        for (int i = 0; i < this.numVertices; i ++) {
            System.out.print( i + " ");
            for (int j = 0; j < this.numVertices; j++){
                System.out.print(this.mat[i][j] + " " );
            }
            System.out. println ();
        }
    }

    // Retorna o n�mero de v�rtices do grafo.
    public int numVertices () {
        return this.numVertices;
    }
    
    
}
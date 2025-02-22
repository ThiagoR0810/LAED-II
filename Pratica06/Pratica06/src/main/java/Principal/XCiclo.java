
package Principal;

public class XCiclo {

    public static final byte branco = 0;
    public static final byte cinza  = 1;
    public static final byte preto  = 2;
    
    private int d[], t[], antecessor[];
    private XGrafo grafo;

    public XCiclo (XGrafo grafo) {
        this.grafo = grafo; 
        int n = this.grafo.numVertices();
        d = new int[n]; 
        t = new int[n]; 
        antecessor = new int[n];
    }

    private int visitaDfs (int u, int tempo, int cor[]) {
        cor[u] = cinza; 
        this.d[u] = ++tempo;
        
        if (!this.grafo.listaAdjVazia (u)) {
            XGrafo.Aresta a = this.grafo.primeiroListaAdj (u);
            while (a != null) {
                int v = a.v2 ();
                if (cor[v] == branco) {
                    this.antecessor[v] = u;
                    tempo = this.visitaDfs (v, tempo, cor);
                }
                if (cor[v] == cinza) { //se acha uma aresta de retorno encerra a busca
                    return -1;
                }
                a = this.grafo.proxAdj (u);
            }
        }
        cor[u] = preto; 
        this.t[u] = ++tempo;
        return tempo;
    }

    public Boolean testaCiclos () 
    {
        int tempo = 0; 
        int cor[] = new int [this.grafo.numVertices ()]; 
        
        for (int u = 0; u < grafo.numVertices (); u++) {
            cor[u] = branco; 
            this.antecessor[u] = -1;
        }     
        
        for (int u = 0; u < grafo.numVertices () && tempo != -1; u++) {
            if (cor[u] == branco) {
                tempo = this.visitaDfs (u, tempo, cor);
                if (tempo == -1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int d (int v) { 
        return this.d[v]; 
    }

    public int t (int v) { 
        return this.t[v]; 
    }

    public int antecessor (int v) { 
        return this.antecessor[v]; 
    }
    
}



public class Aresta{
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
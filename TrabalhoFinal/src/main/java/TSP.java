

import java.util.Vector;

public class TSP{
	
	private XGrafo grafo;
	private Vector<Aresta> edges;
	private Vector<Rota> rotas;
	TSP(){
		this.edges = new Vector<Aresta>();
		this.rotas = new Vector<Rota>();
	}	
	TSP(XGrafo grafo){
		this.edges = new Vector<Aresta>();
		this.rotas = new Vector<Rota>();
		this.grafo = grafo;
	}
    // Utility function to swap two characters in a character array
    private void swap(int[] vertices, int i, int j)
    {
        int temp = vertices[i];
        vertices[i] = vertices[j];
        vertices[j] = temp;
    }
 
    // Recursive function to generate all permutations of a string
    private void permutations(int[] vertices, int currentIndex)
    {
        if (currentIndex == vertices.length - 1) {
        	for(int i=0;i<vertices.length;i++) {
               // System.out.print(String.valueOf(vertices[i]));
        	}
            createRoute(vertices);
        	//System.out.println();
        }
        for (int i = currentIndex; i < vertices.length; i++)
        {
            swap(vertices, currentIndex, i);
            permutations(vertices, currentIndex + 1);
            swap(vertices, currentIndex, i);
        }
    }
 
	private Aresta getEdge(int origem, int destino) {
		Aresta returning = new Aresta();
		for(Aresta a : edges) {
			if( (a.getVerticeOrigem() == origem && a.getVerticeDestino() == destino)||
				(a.getVerticeDestino() == origem && a.getVerticeOrigem() == destino) ) {
				returning = a;
			}
		}
		return returning;
	}
	
    private void createRoute(int[] vertices) {
    	Rota r = new Rota();
    	Vector<Integer> temp = new Vector<>();
    	temp.add(0);
		for(int i=0;i<vertices.length;i++) {
			temp.add(vertices[i]);
		}
    	temp.add(0);
    	//System.out.println(temp.toString());
    	for(int i=0;i<temp.size();i++) {
    		if(i+1 < temp.size()) {
        		r.addAresta(getEdge(temp.elementAt(i), temp.elementAt(i+1)));
    		}
    	}
    	//System.out.println(r.toString());
    	rotas.add(r);
	}
	public void findPermutations(int[] listaVertices, Vector<Aresta> edges) {
 
        // base case
        if (listaVertices == null || listaVertices.length == 0) {
            return;
        }
        this.edges = edges;
        permutations(listaVertices, 0);
    }
	
	public void printWeights() {
		for(int index = 0;index < rotas.size();index++) {
			//System.out.println(rotas.elementAt(index).toString());
		}
		
	}


}

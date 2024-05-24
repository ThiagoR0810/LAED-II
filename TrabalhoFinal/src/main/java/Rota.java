

import java.util.Vector;

public class Rota {
	
	private Vector<Aresta> pathways;
	private int weight;
	
	Rota(){
		this.pathways = new Vector<Aresta>();
	}
	
	public int getPesoRoute() {
		if(weight == 0) {
			for(Aresta a : pathways) {
				weight += a.getPeso();
			}
		}
		return weight;
	}
	
	public void addAresta(Aresta ar) {
		pathways.add(ar);
	}
	
	public String toString() {
		String srt="";
		for(int index=0;index<pathways.size();index++) {
			if(index+2 <= pathways.size()) {
				srt += pathways.elementAt(index).getVerticeOrigem()+"-"+pathways.elementAt(index).getVerticeDestino(); 
				srt += ","; 

			}else {
				srt += pathways.elementAt(index).getVerticeOrigem()+"-"+pathways.elementAt(index).getVerticeDestino(); 

			}
		}
		srt +="	=	"+getPesoRoute();
		return srt;
	}
}

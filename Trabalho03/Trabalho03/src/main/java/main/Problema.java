package main;

import java.util.ArrayList;

public class Problema {
	private int numeroDeCidades;
	private ArrayList<ArrayList<Integer>> distancias;
	public Problema(int nCidades, ArrayList<ArrayList<Integer>> distancias) {
		setNumeroDeCidades(nCidades);
		setDistancias(distancias);
	}

	public String toS() {
		String toS = "";
		toS += "Número de cidades: " + numeroDeCidades + "\nDistâncias entre as cidades:";
		for(int i = 0; i < distancias.size(); i++) {
			toS += "\n" + (i+1) + ": ";
			for (int j = 0; j < distancias.get(i).size(); j++) {
				toS += (j+1) + "(" + distancias.get(i).get(j) + ") ";
			}
		}
		return toS;
	}
	
    /**
	 * @return the numeroDeCidades
	 */
	
    public int getNumeroDeCidades() {
		int aux = numeroDeCidades;
		return aux;
	}
	
    /**
	 * @param numeroDeCidades setar numero de cidades
	 */
	
     public void setNumeroDeCidades(int numeroDeCidades) {
		this.numeroDeCidades = numeroDeCidades;
	}
	
    /**
	 * @return distancia
	 */
	
     public int getDistancia(int de, int para) {
		return distancias.get(de).get(para);
	}
	
    /**
	 * @param distancias setar distancias
	 */
	
     public void setDistancias(ArrayList<ArrayList<Integer>> distancias) {
		this.distancias = distancias;
	}
}
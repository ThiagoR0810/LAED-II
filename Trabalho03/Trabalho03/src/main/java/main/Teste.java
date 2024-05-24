package main;

import java.util.Scanner;

public class Teste {	
	public static void main(String[] args) {
        long start = System.currentTimeMillis();

		System.out.println("\nResolução do Problema do Caixeiro Viajante por Força Bruta:\n");
		System.out.println("Caminho completo do arquivo de entrada: ");
		
        Scanner userInput = new Scanner(System.in);
		String inputFile = userInput.nextLine().replace("\\", "\\\\");
		Arquivo arquivo = new Arquivo(inputFile);

		Problema problema = new Problema(arquivo.getNumeroDeCidades(), arquivo.getDistancias());
		System.out.println("\n" + problema.toS());
		
		AlgoritmoGuloso algoritmoGuloso = new AlgoritmoGuloso();
		ForcaBruta forcaBruta = new ForcaBruta();
		Solucao solucao = new Solucao();
		
        solucao = algoritmoGuloso.solucao(problema);
        solucao = forcaBruta.solucao(problema, solucao);
        System.out.println(solucao.toS());
        
		userInput.close();
        
        long delay = System.currentTimeMillis() - start;
        System.out.println("\nTempo: " + delay + " milissegundos");
	}
}
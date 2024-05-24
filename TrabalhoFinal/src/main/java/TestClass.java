
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class TestClass {

	private XGrafo grafo;
	private Vector<Aresta> vecEdges;
	
	TestClass(){
		this.vecEdges = new Vector<>();
	}
	TestClass(XGrafo grafo){
		this.vecEdges = new Vector<>();
		this.grafo = grafo;
	}
    // Classe interna de retorno, contendo n�mero de vertices e array com as arestas.
    public class Return {
        private final int m_first;
        private final Vector<Aresta> m_second;
    
        public Return(int first, Vector<Aresta> second) {
            m_first = first;
            m_second = second;
        }
    
        public int first() {
            return m_first;
        }
    
        public Vector<Aresta> second() {
            return m_second;
        }
    }
    
    // M�todos dos testes
    public void TesteBase(int i){
    	int[] listaVertex = leArquivoComum(i);
    	TSP solver = new TSP(grafo);
    	long start = System.currentTimeMillis();
        solver.findPermutations(listaVertex, getVecEdges());
        long finish = System.currentTimeMillis();
        System.out.println("Time : "+(finish - start));
        solver.printWeights();
    }
    public void TesteHeuristics(String filename){
    	leArquivoHeuristics(filename);

    }
    
    private int[] leArquivoComum(int n) {
        int[] lista = new int[100];
        for(int i = 0; i < lista.length; i++) {
        	lista[i] = -1;
        }
        int index=0;
    	// Inicializa o scanner e tenta ler.
    	try {
    		File f = new File("src\\tests\\teste"+n+".txt");
    		System.out.println(f.exists());
    		System.out.println(f.getAbsolutePath());
    		Scanner sca = new Scanner(f);
    		
    		int flagV = 0, flagE = 0;
            // Enquanto houverem linhas no arquivo.
    		while(sca.hasNextLine()){
    			// Pega a proxima e salva no buffer linha.
                String linha = sca.nextLine();
                if(linha.contains("VERTICES")) {
                	flagV = 1;
                }else if(linha.contains("EDGES")) {
                	flagE = 1;
                	flagV = 0;
                }else if(flagV == 1) {
                    lista[index] = Integer.parseInt(linha);
                    index++;
                }else if(flagE == 1) {
                	Aresta temp = new Aresta((int)linha.charAt(0) - 48,(int)linha.charAt(2) - 48,(int)Integer.parseInt(linha.substring(4).trim()));
                	vecEdges.add(temp);
                }

    		}
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int[] listaDeVerticesTotal = new int[index];
    	int j = 0;
        for(int i = 0; i < lista.length; i++) {

        	if(lista[i] != -1) {
        		listaDeVerticesTotal[j] = lista[i];
        		j++;
        	}
        }
        int listaDefinitiva[] = new int[listaDeVerticesTotal.length - 1];
        for (int i = 1; i < listaDeVerticesTotal.length; i++) {
        	listaDefinitiva[i-1] = listaDeVerticesTotal[i];
        }
		return listaDefinitiva;

    }
    
    private void leArquivoHeuristics(String filename) {
    	ArrayList<ArrayList<Integer>> matriz = new ArrayList<ArrayList<Integer>>();
    	// Inicializa o scanner e tenta ler.
    	try {
    		File f = new File("src\\tests\\"+filename);
    		System.out.println(f.exists());
    		System.out.println(f.getAbsolutePath());
    		Scanner sca = new Scanner(f);
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		int flagStart = 0;
            // Enquanto houverem linhas no arquivo.
    		while(sca.hasNextLine()){
    			// Pega a proxima e salva no buffer linha.
                String linha = sca.nextLine();
                if(linha.contains("EDGE_WEIGHT_SECTION")) {
                	flagStart = 1;
                }else if(flagStart == 1) {
                	String[] parts = linha.split(" ");
                	for(int i=0;i<parts.length;i++) {
                		System.out.println(parts[i]);
                		if(parts[i].contains("EOF")) {
                			break;
                		}else {
	                		if(!parts[i].isEmpty()) {
	                    		temp.add(Integer.parseInt(parts[i]));
	                		}
                		}
                	}
                	matriz.add(temp);
                	temp.clear();
                	
                }
//                }else if(flagE == 1) {
//                	Aresta temp = new Aresta((int)linha.charAt(0) - 48,(int)linha.charAt(2) - 48,(int)Integer.parseInt(linha.substring(4).trim()));
//                	vecEdges.add(temp);
//                }

    		}
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public Vector<Aresta> getVecEdges() {
		return vecEdges;
	}
}

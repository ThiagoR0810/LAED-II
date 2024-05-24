
package Principal;

import java.io.*;

public class Teste {

    static BufferedReader in = new BufferedReader (new InputStreamReader (System.in));

    public static XGrafo.Aresta lerAresta () throws Exception {
        System.out.println ("Aresta:");
        System.out.print ("  V1:");
        int v1 = Integer.parseInt (in.readLine());
        System.out.print ("  V2:");
        int v2 = Integer.parseInt (in.readLine());
        return new XGrafo.Aresta (v1, v2);
    }

    public static void main (String[] args) throws Exception {
        System.out.print ("O grafo é orientado?\n 1 = SIM e 0 = NÃO\n"); 
        int orientado = Integer.parseInt (in.readLine());
        System.out.print ("No. vertices:"); 
        int nVertices = Integer.parseInt (in.readLine());
        System.out.print ("No. arestas:"); 
        int nArestas = Integer.parseInt (in.readLine());
        XGrafo grafo = new XGrafo (nVertices);

        for (int i = 0; i < nArestas; i++) {
            XGrafo.Aresta a = lerAresta (); 
            grafo.insereAresta (a.v1 (), a.v2 ());
            if (orientado == 0) {
                grafo.insereAresta (a.v2 (), a.v1 ()); 
            }
        }
        //grafo.imprime();
        XCiclo dfs = new XCiclo (grafo);
        if (nArestas >= 3){
            if (dfs.testaCiclos())
                System.out.println("Possui ciclo");
            else
                System.out.println("Não possui ciclo");
        }
    }
}

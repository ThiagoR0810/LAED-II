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
        System.out.print ("  Peso:");
        int peso = Integer.parseInt (in.readLine());
        return new XGrafo.Aresta (v1, v2, peso);
    }

    public static XGrafo.Aresta lerAresta (int u, int v, int p) {
        int v1 = u, v2 = v, peso = p;
        return new XGrafo.Aresta (v1, v2, peso);
    }

    public static void main (String[] args) throws Exception {
        System.out.print ("No. vertices: "); 
        int nVertices = Integer.parseInt (in.readLine());
        System.out.print ("Raiz da AGM: "); 
        int raiz = Integer.parseInt (in.readLine());
        XGrafo grafo = new XGrafo (nVertices);

        //  LETRA A
        XGrafo.Aresta a = null; 
        a = lerAresta (0, 6, 10);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (0, 3, 10);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (0, 4, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (0, 7, 10);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (0, 1, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (6, 5, 15);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (6, 3, 10);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (6, 2, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (2, 4, 10);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (2, 3, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (3, 4, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (1, 5, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (1, 7, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (1, 8, 10);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (7, 8, 20);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (4, 8, 10);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ()); 


        //  LETRA B
        /*XGrafo.Aresta a = null; 
        a = lerAresta (0, 2, 2);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (2, 3, 9);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (3, 4, 6);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (4, 5, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (5, 7, 4);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (0, 1, 8);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (2, 1, 3);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (3, 1, 2);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (4, 1, 7);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (5, 1, 5);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (7, 1, 6);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (0, 6, 9);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (2, 6, 6);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (3, 6, 2);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (4, 6, 4);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (5, 6, 6);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());     
        a = lerAresta (7, 6, 3);
        grafo.insereAresta (a.v1 (), a.v2 (), a.peso ()); grafo.insereAresta (a.v2 (), a.v1 (), a.peso ());*/     

        XAGM agm = new XAGM (grafo);
        agm.obterAgm (raiz);
        System.out.print (""); 
        agm.imprime ();
    }
  
}

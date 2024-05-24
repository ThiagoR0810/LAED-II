// Autor: Thiago Ribeiro Corrêa

package main;

import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        
        // arvores com numeros em ordem crescente
        ArvoreBinaria arvoreS1000 = new ArvoreBinaria(); 
        ArvoreBinaria arvoreS2000 = new ArvoreBinaria();
        ArvoreBinaria arvoreS3000 = new ArvoreBinaria();
        ArvoreBinaria arvoreS4000 = new ArvoreBinaria();
        ArvoreBinaria arvoreS5000 = new ArvoreBinaria();
        ArvoreBinaria arvoreS6000 = new ArvoreBinaria();
        ArvoreBinaria arvoreS7000 = new ArvoreBinaria();
        ArvoreBinaria arvoreS8000 = new ArvoreBinaria();
        ArvoreBinaria arvoreS9000 = new ArvoreBinaria();
        
        // arvores com numeros aleatórios
        ArvoreBinaria arvoreA1000 = new ArvoreBinaria(); 
        ArvoreBinaria arvoreA2000 = new ArvoreBinaria();
        ArvoreBinaria arvoreA3000 = new ArvoreBinaria();
        ArvoreBinaria arvoreA4000 = new ArvoreBinaria();
        ArvoreBinaria arvoreA5000 = new ArvoreBinaria();
        ArvoreBinaria arvoreA6000 = new ArvoreBinaria();
        ArvoreBinaria arvoreA7000 = new ArvoreBinaria();
        ArvoreBinaria arvoreA8000 = new ArvoreBinaria();
        ArvoreBinaria arvoreA9000 = new ArvoreBinaria();

        Random random = new Random();
        
        for (int i = 1; i < 9000; i++) { // preenche as arvores sequenciais com numeros em ordem crescente
            Item item = new Item(i);     // preenche as arvores akeatorias com numeros em ordem aleatoria
            Item itemAleatorio;
            if (i < 1000)
                arvoreS1000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA1000.insere(itemAleatorio);
            if (i < 2000)
                arvoreS2000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA2000.insere(itemAleatorio);
            if (i < 3000)
                arvoreS3000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA3000.insere(itemAleatorio);
            if (i < 4000)
                arvoreS4000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA4000.insere(itemAleatorio);
            if (i < 5000)
                arvoreS5000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA5000.insere(itemAleatorio); 
            if (i < 6000)
                arvoreS6000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA6000.insere(itemAleatorio);
            if (i < 7000)
                arvoreS7000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA7000.insere(itemAleatorio);
            if (i < 8000)
                arvoreS8000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA8000.insere(itemAleatorio);
            arvoreS9000.insere(item); itemAleatorio = new Item(random.nextInt()); arvoreA9000.insere(itemAleatorio);
        }
        
        Item it = new Item(10000);
        long inicio, fim; // variaveis utilizadas para calcular o tempo gasto na pesquisa de um item na árvore binária
        
        inicio = System.nanoTime();
        arvoreS1000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 1000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 1000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS2000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 2000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 2000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS3000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 3000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 3000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS4000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 4000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 4000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS5000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 5000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 5000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS6000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 6000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 6000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS7000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 7000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 7000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS8000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 8000 elementos em ordem crescente: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 8000 elementos em ordem crescente: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreS9000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 9000 elementos em ordem crescente: %d\n\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 9000 elementos em ordem crescente: %d\n\n", it.getContador());
        it.setContador(0);
        
        
        
        inicio = System.nanoTime();
        arvoreA1000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 1000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 1000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA2000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 2000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 2000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA3000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 3000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 3000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA4000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 4000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 4000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA5000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 5000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 5000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA6000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 6000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 6000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA7000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 7000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 7000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA8000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 8000 elementos em ordem aleatoria: %d\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 8000 elementos em ordem aleatoria: %d\n", it.getContador());
        it.setContador(0);
        
        inicio = System.nanoTime();
        arvoreA9000.pesquisa(it);
        fim = System.nanoTime();
        System.out.printf("Tempo da arvore com 9000 elementos em ordem aleatoria: %d\n\n", (fim - inicio));
        System.out.printf("Numero de comparaçoes da arvore com 9000 elementos em ordem aleatoria: %d\n\n", it.getContador());
        it.setContador(0);
        
    }
}

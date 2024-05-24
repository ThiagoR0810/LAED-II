// Aluno: Thiago Ribeiro Correa
// Implemente a busca binária em uma função para procurar um determinado número em uma lista que já está ordenada.

#include <stdio.h>

int buscaBinaria(int tam, int lista[], int alvo) {
    int cont = 0;
    int posicao;
    int min = 0;
    int max = tam - 1;

    while (cont < tam) {
        posicao = (max + min)/2; 
        if (lista[posicao] == alvo)
            break;
        if (lista[posicao] > alvo)
            max = posicao - 1;
        if (lista[posicao] < alvo)
            min = posicao + 1;
        cont++;
    }

    return posicao;
    
}

int main() {
    int lista[] = {-1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int tam = 10;
    int alvo = 0;
    int posicao;
    
    posicao = buscaBinaria(tam, lista, alvo);

    if (lista[posicao] == alvo) {
        printf("O numero %i esta na posicao %i da lista.\n", alvo, posicao);
    } else {
        printf("O numero %i nao esta na lista.\n", alvo);
    }

    return 0;    
}

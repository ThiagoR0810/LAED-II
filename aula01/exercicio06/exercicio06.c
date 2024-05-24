// Aluno: Thiago Ribeiro Correa
// Implemente um outro algoritmo de ordenação (que não seja o quicksort), para ordenar uma lista de números recebida como parâmetro. 

#include <stdio.h>

int main() {
    int tam;
    int aux;

    printf("Digite o tamanho da lista de numeros: ");
    scanf("%i", &tam);

    int lista[tam];

    printf("Digite a lista de números: ");
    for (int i = 0; i < tam; i++) {
        scanf("%i", &lista[i]);
    }

    // algoritmo de ordenação Bubble Sort
    for (int i = 0; i < tam; i++) {
        for (int j = 1; j < tam; j++) {
            if(lista[j] < lista[j - 1]) {
                aux = lista[j - 1];
                lista[j - 1] = lista[j];
                lista[j] = aux;
            }
        }
    }

    printf("Lista ordenada:\n");
    for (int i = 0; i < tam; i++) {
        printf("%i ", lista[i]);
    }
    printf("\n");

    return 0;
}

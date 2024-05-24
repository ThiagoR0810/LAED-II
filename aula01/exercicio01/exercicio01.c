// Aluno: Thiago Ribeiro Correa
/* Faça um programa de computador que solicite ao usuário para preencher uma matriz, do
tamanho que ele desejar, com números. Em seguida o programa deverá imprimir a
quantidade de números pares e ímpares que ele digitou. */

#include <stdio.h>

int main() {
    int row, col;
    int num;
    int pares = 0, impares = 0;

    printf("Digite o numero de linhas da matriz: ");
    scanf("%i", &row);
    printf("Digite o numero de colunas da matriz: ");
    scanf("%i", &col);
    printf("Digite os elementos da matriz: ");

    int matrix[row][col];

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            scanf("%i", &num);
            matrix[i][j] = num;
        }
    }

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            printf("%i ", matrix[i][j]);
        }
        printf("\n");
    }
    
    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            if ((matrix[i][j] % 2) == 0) {
                pares++;
            } else {
                impares++;
            }
        }
    }

    printf("Quantidade de numeros pares: %i\n", pares);
    printf("Quantidade de numeros impares: %i\n", impares);

    return 0;
}
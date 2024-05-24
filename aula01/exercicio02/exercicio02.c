// Aluno: Thiago Ribeiro Correa
/* Faça um programa de computador que possibilite a soma de duas matrizes informadas
pelo usuário. Faça validações para verificar se será possível somar as duas matrizes.*/

#include <stdio.h>

int main() {
    int row1, col1, row2, col2;
    int num1, num2;

    printf("Digite o numero de linhas da matriz 1: ");
    scanf("%i", &row1);
    printf("Digite o numero de colunas da matriz 1: ");
    scanf("%i", &col1);
    printf("Digite os elementos da matriz 1: ");

    int matrix1[row1][col1];

    for(int i = 0; i < row1; i++) {
        for(int j = 0; j < col1; j++) {
            scanf("%i", &num1);
            matrix1[i][j] = num1;
        }
    }

    for(int i = 0; i < row1; i++) {
        for(int j = 0; j < col1; j++) {
            printf("%i ", matrix1[i][j]);
        }
        printf("\n");
    }

    printf("Digite o numero de linhas da matriz 2: ");
    scanf("%i", &row2);
    printf("Digite o numero de colunas da matriz 2: ");
    scanf("%i", &col2);
    printf("Digite os elementos da matriz 2: ");

    int matrix2[row2][col2];

    for(int i = 0; i < row2; i++) {
        for(int j = 0; j < col2; j++) {
            scanf("%i", &num2);
            matrix2[i][j] = num2;
        }
    }

    for(int i = 0; i < row2; i++) {
        for(int j = 0; j < col2; j++) {
            printf("%i ", matrix2[i][j]);
        }
        printf("\n");
    }

    int matrix3[row1][col1];

    if (row1 == row2 && col1 == col2) {
        for(int i = 0; i < row1; i++) {
            for(int j = 0; j < col1; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        printf("Matriz 3 igual a soma das matrizes 1 e 2:\n");

        for(int i = 0; i < row1; i++) {
            for(int j = 0; j < col1; j++) {
                printf("%i ", matrix3[i][j]);
            }
            printf("\n");
        }
    } else {
        printf("Matrizes incompativeis.");
    }

    return 0;
}
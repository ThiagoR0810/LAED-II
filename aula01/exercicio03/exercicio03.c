// Aluno: Thiago Ribeiro Correa
/* Faça um programa de computador que solicite ao usuário para preencher uma matriz com
números. O usuário também definirá o tamanho da matriz. Após o preenchimento, o
programa deverá calcular a soma da diagonal principal e também a soma da diagonal
secundária da matriz.*/

#include <stdio.h>

int main() {
    int row, col;
    int num;
    int somaDiagonalPrinc = 0;
    int somaDiagonalSec = 0;

    printf("Digite o numero de linhas da matriz: ");
    scanf("%i", &row);
    printf("Digite o numero de colunas da matriz: ");
    scanf("%i", &col);

    if (row != col || row == 0 || col == 0) {
        printf("Formato invalido.\n");
        return 0;
    } else { 
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
                if (i == j) {
                    somaDiagonalPrinc = somaDiagonalPrinc + matrix[i][j];
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if ((i + j) == (col - 1)) {
                    somaDiagonalSec = somaDiagonalSec + matrix[i][j];
                }
            }
        }

        printf("Soma da diagonal principal: %i\n", somaDiagonalPrinc);
        printf("Soma da diagonal secundaria: %i\n", somaDiagonalSec);

        return 0;
    }

}

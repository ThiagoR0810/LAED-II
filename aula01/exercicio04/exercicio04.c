// Aluno: Thiago Ribeiro Correa
/*A cidade A tem 40.000 habitantes. A cidade B tem 100.000 habitantes e por fim, a cidade C 
tem 80.000 habitantes. Especialistas acreditam que essas 3 cidades terão um crescimento
populacional de 2% por ano. Escreva um programa de computador que armazene em uma
matriz a população estimada dessas cidades ano após ano, começando por 2023 e
encerrando no ano 2028. No qual, cada linha represente uma cidade e cada coluna uma
previsão de tamanho populacional.*/


#include <stdio.h>

int main() {
    int row = 3;
    int col = 6;
    int matrix[row][col];

    matrix[0][0] = 40000;  // cidade A
    matrix[1][0] = 100000; // cidade B
    matrix[2][0] = 80000;  // cidade C

    for(int i = 0; i < row; i++) {
        for(int j = 1; j < col; j++) {
            matrix[i][j] = matrix[i][j - 1] * 1.02;
        }
    }

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            printf("%i ", matrix[i][j]);
        }
        printf("\n");
    }
    
    return 0;
}
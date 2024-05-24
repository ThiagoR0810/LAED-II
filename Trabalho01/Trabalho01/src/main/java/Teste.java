
import java.util.Scanner;


public class Teste {
    
    public static void main(String[] args) {
        Localizacao.linha = 0; // inicializar cursor
        Localizacao.coluna = 0;
        ArvorePatricia arvore = new ArvorePatricia(128); // palavras de 128 bits

        System.out.println("Lendo o arquivo de teste...");

        try {
            // arquivo com caracteres para ignorar e arquivo para leitura
            ExtraiPalavra palavras = new ExtraiPalavra("delim.txt", "exemplo2.txt");
            String palavra = null;
            while ((palavra = palavras.proximaPalavra()) != null) {
                MeuItem p = new MeuItem(palavra);
                p.adicionaPosicao(new Posicao(Localizacao.linha, Localizacao.coluna));
                arvore.insere(p);
            }
            palavras.fecharArquivos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // pesquisa de palavras
        System.out.println("Digite palavra para busca: [apenas enter para terminar]");
        String obj;
        Scanner scan = new Scanner(System.in);
        do {
            obj = scan.nextLine();
            MeuItem proc = arvore.pesquisa(new MeuItem(obj));
            if (proc == null){
                System.out.println("Palavra não encontrada");
            }
            else {
                if (obj != ""){
                    for(int i = 0; i < proc.recuperaPosicao().size(); i++) {
                        System.out.println((i+1) + "ª ocorrência:\t Linha: " + proc.recuperaPosicao().get(i).recuperaLinha() + 
                        " \tColuna: " + proc.recuperaPosicao().get(i).recuperaColuna());
                    }
                }
            }
        } while (obj != "");
        scan.close();
    }
}
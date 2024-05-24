/* Algoritmo do professor Ziviani */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class ExtraiPalavra {
    private BufferedReader arqDelim, arqTxt;
    private StringTokenizer palavras;
    private String delimitadores;

    public ExtraiPalavra(String nomeArqDelim, String nomeArqTxt)
        throws Exception {
            this.arqDelim = new BufferedReader(new FileReader(nomeArqDelim));
            this.arqTxt = new BufferedReader(new FileReader(nomeArqTxt));
            // Os delimitadores devem estar juntos em uma unica linha do arquivo
            this.delimitadores = arqDelim.readLine() + "\r\n";
            this.palavras = null;
        }

    public String proximaPalavra() throws Exception {
        if (palavras == null || !palavras.hasMoreTokens()) {
          String linha = arqTxt.readLine();
          if (linha == null) {
            return null;
          }
          Localizacao.linha++;
          Localizacao.coluna = 0;
          this.palavras = new StringTokenizer(linha, this.delimitadores);
          if (!palavras.hasMoreTokens()) {
            return ""; // ignora delimitadores
          }
        }
        Localizacao.coluna++;
        return this.palavras.nextToken();
    }

    public void fecharArquivos() throws Exception {
        this.arqDelim.close();
        this.arqTxt.close();
    }
}
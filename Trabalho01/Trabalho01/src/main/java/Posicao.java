
public class Posicao {

    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void alteraPosicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public int recuperaLinha() {
        return this.linha;
    }

    public int recuperaColuna() {
        return this.coluna;
    }
}
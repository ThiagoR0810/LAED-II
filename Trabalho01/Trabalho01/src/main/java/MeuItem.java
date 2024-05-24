

import java.util.ArrayList;

public class MeuItem {

    private String palavra;
    private ArrayList<Posicao> pos; // define a posicao de cada elemento

    public MeuItem(String p) {
        this.palavra = p;
        pos = new ArrayList<Posicao>();
        this.ajustaPalavra();
    }

    public int compara(MeuItem it) { // compara apenas se a palavra eh igual
        MeuItem item = (MeuItem) it;
        if (this.palavra.equals(item.palavra)) {
            return 1;
        }
        return 0;
    }

    public void alteraPalavra(String p) {
        String ch = p;
        this.palavra = ch;
    }

    public String recuperaPalavra() {
      return this.palavra;
    }

    public ArrayList<Posicao> recuperaPosicao() {
        return this.pos;
    }

    public void adicionaPosicao(Posicao nova) {
        pos.add(nova);
    }

    public int tamanho() {
        return this.palavra.length();
    }

    private void ajustaPalavra() { // ajusta a palavra para 16 caracteres e minuscula
        while (this.tamanho() < 16) {
            this.palavra += " ";
        }

        while (this.tamanho() > 16) {
            this.palavra = this.palavra.substring(0, 15);
        }
        this.palavra = this.palavra.toLowerCase();
    }
}
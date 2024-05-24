/* Este codigo foi adaptado do algoritmo do professor Ziviani */


public class ArvorePatricia {

    private static abstract class PatNo {}

    private static class PatNoInt extends PatNo {

        int index;
        PatNo esq, dir;
    }

    private static class PatNoExt extends PatNo {

        MeuItem chave; // O tipo da chave depende da aplicacacao
    }

    private PatNo raiz;
    private int nbitsChave;

    /* Codigo baixo adaptado de 29AjayKumar do site Geeks for Geeks */
    // funcao pra transformar os caracteres de uma string em numeros binarios e
    // retornar a string equivalente
    private String strToBinary(String s) {
        int n = s.length();
        String bin = "";

        for (int i = 0; i < n; i++) {
            String aux = "";
            // converte os caracteres para inteiro (decimal)
            int val = Integer.valueOf(s.charAt(i));
            while (val > 0) { // converter de inteiro para binario usando string
                if (val % 2 == 1) {
                    aux += '1';
                } else
                    aux += '0';
                val /= 2;
            }
            while (aux.length() < 8) { // acrescenta zeros para que o tamanho do numero seja de 8 bits
                aux += "0";
            }
            aux = reverse(aux); // inverte o caractere em binario binario para finalizar
            bin += aux; // acrescenta o o caractere em string de binario na string final
        }
        return bin;
    }

    // retorna string binaria
    static String reverse(String input) {
        char[] a = input.toCharArray();
        int l, r = 0;
        r = a.length - 1;

        for (l = 0; l < r; l++, r--) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }

    /************************************************************/

    // Retorna o i-esimo bit da chave k a partir da esquerda
    private int bit(int i, MeuItem item) {
        if (i == 0) {
            return 0;
        }
        // retorna o item como uma string pra poder chamar o strToBinary e retornar um
        // vetor de binarios
        String s = item.recuperaPalavra();
        s = strToBinary(s);
        char c[] = { s.charAt(i - 1) };
        return Integer.valueOf(new String(c));
    }

    // Verifica se p eh nó externo
    private boolean eExterno(PatNo p) {
        Class<?> classe = p.getClass();
        return classe.getName().equals(PatNoExt.class.getName());
    }

  // cria um no interno
    private PatNo criaNoInt(int i, PatNo esq, PatNo dir) {
        PatNoInt p = new PatNoInt();
        p.index = i;
        p.esq = esq;
        p.dir = dir;
        return p;
    }

    // cria no externo
    private PatNo criaNoExt(MeuItem item) {
        PatNoExt p = new PatNoExt();
        p.chave = item;
        return p;
    }

    // pesquisa com char
    private MeuItem pesquisa(MeuItem item, PatNo t) {
        if (this.eExterno(t)) { // verifica se o elemento eh o mesmo se estivermos no ultimo elemento possivel
            PatNoExt aux = (PatNoExt) t;
        if (aux.chave.compara(item) == 1) {
            return aux.chave;
        } else {
            return null;
        }
        } else {
            PatNoInt aux = (PatNoInt) t;
            if (this.bit(aux.index, item) == 0) { // verifica se bit eh 0 ou 1 e procura recursivamente
                return pesquisa(item, aux.esq);
            } else {
                return pesquisa(item, aux.dir);
            }
        }
    }

    // insere um elemento entre elementos existentes
    private PatNo insereEntre(MeuItem k, PatNo t, int i) {
        PatNoInt aux = null;
        if (!this.eExterno(t)) {
            aux = (PatNoInt) t;
        }
        if (this.eExterno(t) || (i < aux.index)) { // Cria um novo nó externo e um novo nó interno
            PatNo p = this.criaNoExt(k); // contendo o o indice i e a chave respectivamente
            if (this.bit(i, k) == 1) {
                return this.criaNoInt(i, t, p);
            } else {
                return this.criaNoInt(i, p, t);
            }
        } else { // Se a posicao nao for a correta buscar na arvore recursivamente;
            if (this.bit(aux.index, k) == 1) {
                aux.dir = this.insereEntre(k, aux.dir, i);
            } else {
                aux.esq = this.insereEntre(k, aux.esq, i);
            }
        return aux;
        }
    }

  // insercao de elementos na patricia
    private PatNo insere(MeuItem k, PatNo t) {
        if (t == null) {
            return this.criaNoExt(k); // primeiro item a ser criado
        } else {
            PatNo p = t;
            while (!this.eExterno(p)) { // procura o proximo no externo
                PatNoInt aux = (PatNoInt) p;
                if (this.bit(aux.index, k) == 1) {
                    p = aux.dir;
                } else {
                    p = aux.esq;
                }
            }
            PatNoExt aux = (PatNoExt) p;
            int i = 1; // acha o primeiro bit diferente
            while ((i <= this.nbitsChave) && (this.bit(i, k) == this.bit(i, aux.chave))) {
                i++;
            }
            if (i > this.nbitsChave) { // se nao ha bits diferentes, adiciona outra ocorrencia da palavra
                aux.chave.adicionaPosicao(k.recuperaPosicao().get(0));
                return t;
            } else {
                return this.insereEntre(k, t, i); // adiciona nova chave
            }
        }
    }

    private void central(PatNo pai, PatNo filho, String msg) {
        if (filho != null) {
            if (!this.eExterno(filho)) {
                PatNoInt aux = (PatNoInt) filho;
                central(filho, aux.esq, "ESQ");
                if (pai != null)
                    System.out.println("Pai: " + ((PatNoInt) pai).index + " " + msg + " Int: " + aux.index);
                else
                    System.out.println("Pai: " + pai + " " + msg + " Int: " + aux.index);
                central(filho, aux.dir, "DIR");
            } else {
                PatNoExt aux = (PatNoExt) filho;
                if (pai != null)
                    System.out.println("Pai: " + ((PatNoInt) pai).index + " " + msg + " Ext: " + aux.chave);
                else
                    System.out.println("Pai: " + pai + " " + msg + " Ext: " + aux.chave);
            }
        }
    }

    public void imprime() {
        this.central(null, this.raiz, "RAIZ");
    }

    public ArvorePatricia(int nbitsChave) {
        this.raiz = null;
        this.nbitsChave = nbitsChave;
    }

    public MeuItem pesquisa(MeuItem k) {
        return this.pesquisa(k, this.raiz);
    }

    public void insere(MeuItem k) {
        this.raiz = this.insere(k, this.raiz);
    }
}
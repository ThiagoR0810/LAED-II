// Autor: Thiago Ribeiro Corrêa

package main;

public class ArvoreBinaria {
    
    private static class No {
        Item reg;
        No esq, dir;
    }
    
    private No raiz;
    
    private Item pesquisa (Item reg, No p) { // procura determinado elemento na arvore passando por parametro o proprio elemento e a raiz
        if (p == null)
            return null; // Registro nao encontrado
        else if (reg.compara(p.reg) < 0)
            return pesquisa(reg, p.esq); // vai para a subarvore da esquerda e faz a chamada recursiva atualizando a raiz
        else if (reg.compara(p.reg) > 0)
            return pesquisa(reg, p.dir); // vai para a subarvore da direita e faz a chamada recursiva atualizando a raiz
        else
            return p.reg; // Registro encontrado
    }
    
    private No insere (Item reg, No p) { // insere determinado elemento na arvore
        if (p == null) { // raiz eh nula entao pode-se inserir o elemento
            p = new No(); p.reg = reg;
            p.esq = null; p.dir = null;
        }
        else if (reg.compara(p.reg) < 0) // verifica se o elemento a ser inserido eh menor que a raiz nao nula da arvore ou subarvore
            p.esq = insere (reg, p.esq); // caso seja menor, faz a chamada recursiva atualizando a raiz
        else if (reg.compara(p.reg) > 0) // verifica se o elemento a ser inserido eh maior que a raiz nao nula da arvore ou subarvore
            p.dir = insere (reg, p.dir); // caso seja maior, faz a chamada recursiva atualizando a raiz
        else
            System.out.println("Erro: Registro ja existente"); // encontrou-se um elemento na arvore igual ao elemento que se deseja inserir
        return p;
    }
    
    private No antecessor (No q, No r) {
        if (r.dir != null)
            r.dir = antecessor (q, r.dir);
        else
            q.reg = r.reg; r = r.esq;
        return r;
    }
    
    private No retira (Item reg, No p) {
        if (p == null)
            System.out.println("Erro: Registro nao encontrado");
        else if (reg.compara(p.reg) < 0)
            p.esq = retira (reg, p.esq);
        else if (reg.compara(p.reg) > 0)
            p.dir = retira (reg, p.dir);
        else {
            if (p.dir == null)
                p = p.esq;
            else if (p.esq == null)
                p = p.dir;
            else
                p.esq = antecessor (p, p.esq);
        }
        return p;
    }
    
    public ArvoreBinaria () {
        this.raiz = null;
    }
    
    public Item pesquisa (Item reg) {
        return this.pesquisa(reg, this.raiz);
    }
    
    public void insere (Item reg) {
        this.raiz = this.insere(reg, this.raiz);
    }
    
    public void retira (Item reg) {
        this.raiz = this.retira(reg, this.raiz);
    }
}

package main;

public class ArvoreSBB {
    private static class No { 
        Item reg; 
        No esq, dir;
        byte incE, incD;
    }
    private static final byte Horizontal = 0; 
    private static final byte Vertical = 1; 
    private No raiz;
    private boolean propSBB;

    private Item pesquisa (Item reg, No p, int n) { //pesquisa por um item na arvore a partir do metodo compara da classe Item, olhando se o que procuramos é maior ou menor que o nó analisado e chamando recursivamente o método
        if (p == null) {
            System.out.println ("Comparações: "+ n);
            return null;
        }
        else {
            if (reg.compara (p.reg) < 0)
            { 
                n++;
                return pesquisa (reg, p.esq, n);
            }
            else if (reg.compara (p.reg) > 0) 
            {
                n++;
                return pesquisa (reg, p.dir, n);
            }
        }
        return p.reg;
  }


    private No ee (No ap) {
        No ap1 = ap.esq; ap.esq = ap1.dir; ap1.dir = ap;
        ap1.incE = Vertical; ap.incE = Vertical; ap = ap1;
        return ap; 
    }

    private No ed (No ap) {
        No ap1 = ap.esq; No ap2 = ap1.dir; ap1.incD = Vertical;
        ap.incE = Vertical; ap1.dir = ap2.esq; ap2.esq = ap1;
        ap.esq = ap2.dir; ap2.dir = ap; ap = ap2;    
        return ap; 
    }

    private No dd (No ap) {
        No ap1 = ap.dir; ap.dir = ap1.esq; ap1.esq = ap;
        ap1.incD = Vertical; ap.incD = Vertical; ap = ap1;
        return ap; 
    }

    private No de (No ap) {
        No ap1 = ap.dir; No ap2 = ap1.esq; ap1.incE = Vertical;
        ap.incD = Vertical; ap1.esq = ap2.dir; ap2.dir = ap1;
        ap.dir = ap2.esq; ap2.esq = ap; ap = ap2;    
        return ap; 
    }

    private No insere (Item reg, No pai, No filho, boolean filhoEsq) { //insere um item na arvore a partir do metodo compara da classe Item, olhando se o que procuramos é maior ou menor que o nó analisado e chamando recursivamente o método para a inserção, realizando as transformações necessárias a medida que são necessitadas
        if (filho == null) {
            filho = new No (); filho.reg = reg; 
            filho.incE = Vertical; filho.incD = Vertical;
            filho.esq = null; filho.dir = null;
            if (pai != null)
                if (filhoEsq) pai.incE = Horizontal; else pai.incD = Horizontal;
            this.propSBB = false;
        }
        else if (reg.compara (filho.reg) < 0) {
            filho.esq = insere (reg, filho, filho.esq, true);
            if (!this.propSBB) 
            if (filho.incE == Horizontal) { 
                if (filho.esq.incE == Horizontal) {
                    filho = this.ee (filho); //trasformação esquerda-esquerda
                    if (pai != null)
                        if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;
                }
                else if (filho.esq.incD == Horizontal) {
                    filho = this.ed (filho); //trasformação esquerda-direita
                    if (pai != null) 
                        if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;            
                }
            }
            else this.propSBB = true;
        }
        else if (reg.compara (filho.reg) > 0) {
            filho.dir = insere (reg, filho, filho.dir, false);
            if (!this.propSBB) 
            if (filho.incD == Horizontal) {
                if (filho.dir.incD == Horizontal) {
                    filho = this.dd (filho); //trasformação direita-direita
                    if (pai != null)
                        if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;
                }
                else if (filho.dir.incE == Horizontal) {
                    filho = this.de (filho); //trasformação direita-esquerda
                    if (pai != null)
                        if (filhoEsq) pai.incE=Horizontal; else pai.incD=Horizontal;            
                }
            }
            else this.propSBB = true;
        }
      else {      
            System.out.println ("Erro: Registro ja existente"); 
            this.propSBB = true;
      }
      return filho; 
    }

    public ArvoreSBB () {
        this.raiz = null;
        this.propSBB = true;
    }

    public Item pesquisa (Item reg, int n) {
        return this.pesquisa (reg, this.raiz, n);
    }

    public void insere (Item reg) {
        this.raiz = insere (reg, null, this.raiz, true);
    }
}

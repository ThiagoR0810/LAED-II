// Autor: Thiago Ribeiro Corrêa

package main;

public class Item {

    private int chave;
    private int contador;
    
    public Item(int chave) {
        this.chave = chave;
        this.contador = 0;
    }
    
    public int compara(Item it) {
        this.contador++;
        Item item = it;
        if (this.chave < item.chave)
            return -1;
        else if (this.chave > item.chave)
            return 1;
        return 0;
    }

    public int getChave() {
        return chave;
    }
    
    public int getContador() {
        return contador;
    }
    
    public void setContador(int contador) {
        this.contador = contador;
    }
    
}

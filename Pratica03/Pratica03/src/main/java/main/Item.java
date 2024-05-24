package main;

public class Item {
    private int chave;
    
    public Item(int chave) {
        this.chave = chave;
    }
    
    public int compara(Item it) { //compara pra ver se o item é maior ou menor do que o que estamos analisando no momento
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
}
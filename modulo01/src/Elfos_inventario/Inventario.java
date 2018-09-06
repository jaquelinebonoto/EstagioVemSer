/*Crie uma classe chamada Inventario, que representará toda mochila de itens
 * dos Elfos (ou seja, terá um array de Item). Caso seja informado um número, 
 * na construção do Inventario, este deverá ser o tamanho do array de Item. 
 * Caso não seja informado número, o array terá inicialmente 99 slots 
 * para itens. Inicialmente o Inventário possuirá duas operações básicas:
●   adicionar(Item) - recebe uma instância de item e adiciona no primeiro slot que tiver referência null
●   obter(posicao) - retorna o item correspondente àquela posição no array
    ●   remover(posicao) - remove o item correspondente àquela posição no array (setando para null sua referência)
*/
public class Inventario{
    private Item[] inventario; //declarando o vetor. inventario é a referencia
      
    public Inventario(){
         this(99);
    }
    
    public Inventario(int n){
         this.inventario = new Item[n];
    }

    public Item[] adicionaItem(Item item){
        for(Item i : this.inventario){
            if (i==null) i=item;
	}
        return inventario;
    }
    
    public Item getItem(int n){
        return this.inventario[n];
    }
    
}

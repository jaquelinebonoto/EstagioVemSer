import java.util.ArrayList;
import java.lang.String;

public class InventarioList {
    private ArrayList<Item> itens = new ArrayList<>();

    public InventarioList(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public void adicionar(ArrayList<Item> itens) {
        this.itens = itens;
    }

    /*public int buscarItem(ArrayList<Item> itens, String descricao){
    for (int i = 0; i < itens.size(); i++) {
    if (itens.get(i).contains(descricao)) {
    return i;
    }
    }
    return -1;
    }*/

    public Item buscarItem(String descricao){
        int i = 0;
        for(i = 0; i < itens.size(); i ++){  
            if(itens.get(i).getDescricao().equals(descricao))  
                break;
        }
        return itens.get(i);
    }

    /*        
    int n=0;
    StringBuilder descricoes = new StringBuilder();
    for (int i = 0; i < itens.size(); i++) {
    if(itens.contains(descricao)) n = i;
    descricoes.append(descricao);
    }
    return descricoes.toString();
    }

    public Item obter(int posicao) {
    return this.itens[posicao];
    }

    public void remover(int posicao) {
    this.itens[posicao] = null;
    posicaoAPreencher = posicao;
    }

    public String getDescricoesItens() {
    StringBuilder descricoes = new StringBuilder();
    for (int i = 0; i < this.itens.length; i++) {
    if (this.itens[i] != null) {
    String descricao = this.itens[i].getDescricao();
    descricoes.append(descricao);
    boolean deveColocarVirgula = i < this.ultimaPosicaoPreenchida;
    if (deveColocarVirgula) {
    descricoes.append(",");
    }
    }
    }

    return descricoes.toString();
    }

    public Item getItemComMaiorQuantidade() {

    int indice = 0, maiorQuantidadeParcial = 0;
    for (int i = 0; i < this.itens.length; i++) {
    if (this.itens[i] != null) {
    int qtdAtual = this.itens[i].getQuantidade();
    if (qtdAtual > maiorQuantidadeParcial) {
    maiorQuantidadeParcial = qtdAtual;
    indice = i;
    }
    }
    }
    return this.itens.length > 0 ? this.itens[indice] : null;
    }
     */
}

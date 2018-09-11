public class Personagem {
    protected String nome;
    protected double vida;
    protected Status status;
    protected Inventario inventario;

    public Personagem(String nome, double vida, Status status) {
        this.nome = nome;
        this.vida = vida;
        this.status = status;
    }

    public String getNome() {
        return this.nome;
    }

    public double getVida() {
        return this.vida;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void ganharItem(Item item){
        int quant = item.getQuantidade();
        for (int i=0; i<=this.inventario.tamanhoInventario()-1; i++){
            if(item.equals(inventario.obter(i))){
                item.setQuantidade(inventario.obter(i).getQuantidade() + quant);
            }
            inventario.adicionar(item);
        }           
    }

    public void perderItem(){

    }

    public Inventario getInventario(){
        return this.inventario;
    }

    public void setInventario (Inventario inventario){
        this.inventario = inventario;
    }
}

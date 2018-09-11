public abstract class Personagem {
    protected String nome;
    protected double vida;
    protected Status status;
    protected Inventario inventario;
    protected double QTD_DANO;

    Personagem(String nome, double vida, Status status) {
        this.nome = nome;
        this.vida = vida;
        this.status = status;
        this.inventario = new Inventario();
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

    public void ganharItem(Item item) {
        this.inventario.adicionar(item);
    }

    public void perderItem(Item item) {
        // discussao a cerca da Law of Demeter
        this.inventario.getItens().remove(item);
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public void perderVida() {
        vida -= vida >= QTD_DANO ? QTD_DANO : vida;
        if (vida == 0.0) {
            this.status = Status.MORTO;
        }
    }
}

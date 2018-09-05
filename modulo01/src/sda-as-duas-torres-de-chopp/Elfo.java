public class Elfo {
    private String nome;
    private int qtdFlechas;
    private int experiencia;

    // type initializer
    {
        qtdFlechas = 7;
        experiencia = 0;
    }

    public Elfo(String nomeInformado) {
        nome = nomeInformado;
    }

    public String getNome() {
        return nome;
    }

    public void atirarFlecha() {
        if (qtdFlechas > 0) {
            qtdFlechas--;
            experiencia++;
        }
    }

    public int getQtdFlechas() {
        return this.qtdFlechas;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    
    
    
    
}
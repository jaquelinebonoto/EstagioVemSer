
    public class Elfo {
    private String nome;
    private int experiencia;
    private Item arco;
    private Item flecha;
    
    //type initializer
    {
        experiencia = 0;
        arco = new Item("Arco", 1);
        flecha = new Item ("Flecha", 7);
    }
   
    public Elfo (String nomeElfo) {
        this.nome = nomeElfo;
    }
 
    public String getNome (){
        return nome;
    }
    
    public void atirarFlecha() {
        if (flecha.getQuantidade() > 0) return;
        //qtdFlechas--;
        flecha.setQuantidade(flecha.getQuantidade()-1);
        experiencia++;
    }
    
    public int getExperiencia () {
         return experiencia;
    }
    
    public int getQtdFlechas(){
        return flecha.getQuantidade();
    }        
    
    
}

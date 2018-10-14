
package questao2;

public class Projeto {
    private String titulo;
    private Data datainicio;
    private Data datafim;

    public Projeto() {}

    public Projeto(String titulo, Data datainicio, Data datafim) {
        this.titulo = titulo;
        this.datainicio = datainicio;
        this.datafim = datafim;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public void setDatainicio(Data datainicio) {
        this.datainicio = datainicio;
    }

    public Data getDatafim() {
        return datafim;
    }

    public void setDatafim(Data datafim) {
        this.datafim = datafim;
    }

    void setDataFim(Data data) {
        this.datafim = data;
    }

    Data getDataInicio() {
        return datainicio;
    }

    @Override
    public String toString() {
        return "Projeto{" + "titulo=" + titulo + ", datainicio=" + datainicio + ", datafim=" + datafim + '}';
    }
    
    
}

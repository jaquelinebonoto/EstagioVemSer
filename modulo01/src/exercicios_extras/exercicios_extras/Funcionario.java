public class Funcionario {
    
    private String nome;
    private double salarioFixo;
    private double totalVendas;
    private final double imposto = 10/100.0;
    private final double comissao = 15/100.0;
    
    public Funcionario(String nome, double salarioFixo, double totalVendas) {
        this.nome = nome;
        this.salarioFixo = salarioFixo;
        this.totalVendas = totalVendas;
    }
    
    public double getLucro() {
        double salarioLiquido = this.salarioFixo * (1-imposto);
        double valorComissao = this.totalVendas * comissao;
        double comissaoLiquida = valorComissao * (1-imposto);
        return salarioLiquido + comissaoLiquida;
    }
}
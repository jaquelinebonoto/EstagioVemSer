/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao20;

/**
 *
 * @author silviacb
 */
public enum Palavras {
    PALAVRA1 ("Casa"), PALAVRAO2 ("Case");
    
    private final String valor;
    Palavras(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

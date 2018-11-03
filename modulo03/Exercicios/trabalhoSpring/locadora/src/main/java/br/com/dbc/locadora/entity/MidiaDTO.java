
package br.com.dbc.locadora.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jaqueline.bonoto
 */
//@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MidiaDTO {
    private Tipo tipo;
    private int quantidade;
    private double valor;
    
    //criar método para transformar midiaDto em Midia
    public Midia DtotoMidia (Filme filme){
            return Midia.builder()
                    .tipo(this.tipo)
                    .filme(filme)
                    .aluguel(null)
                    .build();
    }

}

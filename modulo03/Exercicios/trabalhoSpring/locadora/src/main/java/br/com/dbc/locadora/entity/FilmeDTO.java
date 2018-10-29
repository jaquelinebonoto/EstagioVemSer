
package br.com.dbc.locadora.entity;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jaqueline.bonoto
 */

@Getter
public class FilmeDTO {
    
    private String titulo;
    //@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lancamento;
    private Categoria categoria;
    private List<MidiaDTO> midia;
    
    //criar um método para transformar filmeDTO em filme
    public Filme DtotoFilme(){
        return Filme.builder()
                .titulo(this.titulo)
                .lancamento(lancamento)
                .categoria(this.categoria)
                .build();
    }
}

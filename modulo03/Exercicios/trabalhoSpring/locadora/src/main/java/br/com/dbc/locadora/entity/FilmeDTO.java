
package br.com.dbc.locadora.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jaqueline.bonoto
 */
@Data
public class FilmeDTO {
    private String titulo;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDate lancamento;
    
    private String categoria;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filme")
    private List<Midia> midiaList;
}

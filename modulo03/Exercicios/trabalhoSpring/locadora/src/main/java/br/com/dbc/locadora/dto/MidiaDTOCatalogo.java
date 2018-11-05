
package br.com.dbc.locadora.dto;

import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.Tipo;
import br.com.dbc.locadora.entity.ValorMidia;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jaqueline.bonoto
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MidiaDTOCatalogo {
    private Tipo tipo;
    private Double valorVigente;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime disponibilidade;    
    
    
}

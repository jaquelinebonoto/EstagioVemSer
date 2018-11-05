
package br.com.dbc.locadora.dto;

import br.com.dbc.locadora.entity.Filme;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jaqueline.bonoto
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDTO{
        private Filme filme;
        private List<MidiaDTOCatalogo> midias;      
}

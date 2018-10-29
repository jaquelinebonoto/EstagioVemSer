
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jaqueline.bonoto
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AluguelDTO implements Serializable {
    private Long idCliente;
    private List<Long> midias;     

}

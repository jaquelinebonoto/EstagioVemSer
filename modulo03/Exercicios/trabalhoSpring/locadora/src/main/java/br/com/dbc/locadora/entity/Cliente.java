
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jaqueline.bonoto
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CLIENTE")

public class Cliente extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name= "S_CLIENTE", sequenceName = "S_CLIENTE", allocationSize=1)
    @GeneratedValue(generator = "S_CLIENTE", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    
    private Long telefone;

    private String rua;
    
    private String bairro;
    
    private String cidade;
    
    private String estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Aluguel> aluguelList;

    @Override
    public Long getId() {
        return id;
    }
      
}

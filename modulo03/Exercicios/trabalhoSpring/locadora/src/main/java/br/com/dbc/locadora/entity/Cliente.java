
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull
    @SequenceGenerator(name= "S_CLIENTE", sequenceName = "S_CLIENTE", allocationSize=1)
    @GeneratedValue(generator = "S_CLIENTE", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "NOME")
    private String nome;
    
    @NotNull
    @Size(min = 6, max = 12)
    @Column(name = "TELEFONE")
    private String telefone;

    private String rua;

    private String bairro;
    
    private String cidade;
    
    private String estado;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    //private List<Aluguel> aluguelList;

    @Override
    public Long getId() {
        return id;
    }
      
}

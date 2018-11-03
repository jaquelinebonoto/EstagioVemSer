
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_SEQ")
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TELEFONE")
    private String telefone;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RUA")
    private String rua;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BAIRRO")
    private String bairro;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CIDADE")
    private String cidade;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ESTADO")
    private String estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Aluguel> aluguelList;

    @Override
    public Long getId() {
        return id;
    }
      
}

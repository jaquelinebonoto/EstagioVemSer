
package br.com.dbc.locadora.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jaqueline.bonoto
 */
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Aluguel extends AbstractEntity<Long> implements Serializable {
   
    @Id
    @SequenceGenerator(name= "S_ALUGUEL", sequenceName = "ANIMAL_SEQ", allocationSize=1)
    @GeneratedValue(generator = "S_ALUGUEL", strategy = GenerationType.SEQUENCE)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate retirada; // = LocalDate.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate previsao;// = LocalDate.now().plusDays(getMidias().size());    
  
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate devolucao;

    private Double multa;
    
    
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Cliente cliente;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluguel")
    private List<Midia> midias;*/

    @Override
    public Long getId() {
        return id;
    }

}

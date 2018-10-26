
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jaqueline.bonoto
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Aluguel extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDate retirada;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDate previsao;    
  
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDate devolucao;

    private Double multa;
    
    
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "aluguel")
    private List<Midia> midiaList;

    @Override
    public Long getId() {
        return id;
    }
    
}

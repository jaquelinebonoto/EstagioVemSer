
package br.com.dbc.locadora.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @SequenceGenerator(name= "S_ALUGUEL", sequenceName = "S_ALUGUEL", allocationSize=1)
    @GeneratedValue(generator = "S_ALUGUEL", strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime retirada; // = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime previsao;// = LocalDate.now().plusDays(getMidias().size());    
  
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDateTime devolucao;

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

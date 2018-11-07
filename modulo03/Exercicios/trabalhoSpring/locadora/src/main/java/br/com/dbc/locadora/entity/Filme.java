
package br.com.dbc.locadora.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "FILME")

public class Filme extends AbstractEntity<Long> implements Serializable {

    @Id
    @NotNull
    @SequenceGenerator(name= "S_FILME", sequenceName = "S_FILME", allocationSize=1)
    @GeneratedValue(generator = "S_FILME", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "TITULO")
    private String titulo;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate lancamento;
    
    private Categoria categoria;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "filme")
    //private List<Midia> midia;

    @Override
    public Long getId() {
        return id;
    }
    
}

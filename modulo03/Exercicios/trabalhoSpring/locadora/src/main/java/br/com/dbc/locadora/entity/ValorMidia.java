package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Setter
@Table(name = "VALOR_MIDIA")
@NamedQueries({
    @NamedQuery(name = "ValorMidia.findAll", query = "SELECT v FROM ValorMidia v")})
public class ValorMidia extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name= "S_VALOR_MIDIA", sequenceName = "S_VALOR_MIDIA", allocationSize=1)
    @GeneratedValue(generator = "S_VALOR_MIDIA", strategy = GenerationType.SEQUENCE)
    private Long id;

    private double valor;

    //@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inicioVigencia;
    
    //@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fimVigencia;
    
    @JoinColumn(name = "ID_MIDIA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Midia midia;

 
    @Override
    public Long getId() {
        return id;
    }
    
}

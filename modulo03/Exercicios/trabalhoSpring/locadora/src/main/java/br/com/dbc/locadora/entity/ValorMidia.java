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
import javax.persistence.Table;
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
@Table(name = "VALOR_MIDIA")
@NamedQueries({
    @NamedQuery(name = "ValorMidia.findAll", query = "SELECT v FROM ValorMidia v")})
public class ValorMidia extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double valor;

    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDate inicioVigencia;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDate fimVigencia;
    
    @JoinColumn(name = "ID_MIDIA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Midia midia;

 
    @Override
    public Long getId() {
        return id;
    }
    
}

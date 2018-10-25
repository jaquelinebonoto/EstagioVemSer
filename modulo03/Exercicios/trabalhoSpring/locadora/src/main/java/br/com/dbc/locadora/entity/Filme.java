package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jaqueline.bonoto
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 

public class Filme extends AbstractEntity<Long> implements Serializable {

  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private LocalDate lancamento;
    
    private String categoria;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "filme")
    private Midia midia;

    @Override
    public Long getId() {
        return id;
    }
    

}

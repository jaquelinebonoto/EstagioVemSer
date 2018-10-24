
package br.com.dbc.seguradora.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
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

public class Apolice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicioVigencia;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate finalVigencia;
    
}

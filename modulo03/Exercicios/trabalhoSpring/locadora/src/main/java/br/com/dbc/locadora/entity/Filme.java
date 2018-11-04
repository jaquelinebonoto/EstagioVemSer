/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "FILME")

public class Filme extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name= "S_FILME", sequenceName = "S_FILME", allocationSize=1)
    @GeneratedValue(generator = "S_FILME", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titulo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lancamento;
    
    private Categoria categoria;


    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "filme")
    //private List<Midia> midia;

    @Override
    public Long getId() {
        return id;
    }
    
}

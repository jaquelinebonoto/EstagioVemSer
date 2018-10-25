package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 


public class Midia extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String tipo;
    
    private Integer quantidade;
    @JoinTable(name = "ALUGUEL_MIDIA", joinColumns = {
        @JoinColumn(name = "ID_MIDIA", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ALUGUEL", referencedColumnName = "ID")})
    @ManyToMany
    private List<Aluguel> aluguelList;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "midia")
    private ValorMidia valorMidia;
    
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Filme filme;

    @Override
    public Long getId() {
        return id;
    }

    
}

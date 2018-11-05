
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

/**
 *
 * @author jaqueline.bonoto
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "MIDIA")
@NamedQueries({
    @NamedQuery(name = "Midia.findAll", query = "SELECT m FROM Midia m")})
public class Midia extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name= "S_MIDIA", sequenceName = "S_MIDIA", allocationSize=1)
    @GeneratedValue(generator = "S_MIDIA", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "midia")
    //private List<ValorMidia> valorMidiaList;
    @JoinColumn(name = "ID_ALUGUEL", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private Aluguel aluguel;
    @JoinColumn(name = "ID_FILME", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Filme filme;

    @Override
    public Long getId() {
        return id;
    }
 
    
}

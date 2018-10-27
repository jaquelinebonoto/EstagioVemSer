
package br.com.dbc.locadora.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Tipo tipo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "midia")
    private List<ValorMidia> valorMidia;
    @JoinColumn(name = "ID_ALUGUEL", referencedColumnName = "ID")
    @ManyToOne
    private Aluguel aluguel;
    @JoinColumn(name = "ID_FILME", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Filme filme;

    @Override
    public Long getId() {
        return id;
    }


    

 
    
}

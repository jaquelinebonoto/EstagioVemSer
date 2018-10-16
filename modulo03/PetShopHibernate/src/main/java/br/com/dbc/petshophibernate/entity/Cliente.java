
package br.com.dbc.petshophibernate.entity;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "CLIENTE")
@NamedQueries({
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends AbstractEntity<Long> implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name= "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize=1)
    @GeneratedValue(generator = "CLIENTE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "NOME")
    private String nome;
    @JoinTable(name = "CLIENTE_ANIMAL", joinColumns = {
        @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID")})
    @ManyToMany (cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Animal> animalList;

   
    
}

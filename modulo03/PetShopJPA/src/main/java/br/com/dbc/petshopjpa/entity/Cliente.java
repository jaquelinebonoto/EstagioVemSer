
package br.com.dbc.petshopjpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author jaqueline.bonoto
 */
@Entity
@Table(name = "CLIENTE")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

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
    private List<Animal> animalList;
    
}

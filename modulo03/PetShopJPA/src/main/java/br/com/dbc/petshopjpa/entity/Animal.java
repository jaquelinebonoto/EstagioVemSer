
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
@Table(name = "ANIMAL")
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name= "ANIMAL_SEQ", sequenceName = "ANIMAL_SEQ", allocationSize=1)
    @GeneratedValue(generator = "ANIMAL_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @ToString.Exclude
    @ManyToMany(mappedBy = "animalList", cascade = CascadeType.ALL)
    private List<Cliente> clienteList;


    
}

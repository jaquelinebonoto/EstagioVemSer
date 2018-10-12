package br.com.dbc.produtosvenda.produtosvenda.entity;
import java.io.Serializable;
import javax.persistence.*;


    @Entity
    @Table(name = "PRODUTO")
    @NamedQueries({
    @NamedQuery(name = "PRODUTO.findAll", query = "SELECT n FROM NOTA n")})

public class Nota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTA_SEQ")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "NOTA_SEQ", sequenceName = "NOTA_SEQ")
    @Column(name = "IDNOTA", nullable = false)
    private Long idNota;
    @Column(name = "DESCRICAONOTA", nullable = false, length = 500)
    private String descricaoNota;
    
    /*
    @Column(name = "SEXO", nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private SexoType sexo;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @Column(name = "VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
*/

    public Nota() {
    }

    public Nota(Long idNota) {
        this.idNota = idNota;
    }

    public Nota(Long idNota, String descricaoNota) {
        this.idNota = idNota;
        this.descricaoNota = descricaoNota;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setId(Long idNota) {
        this.idNota = idNota;
    }

    public String getDescricaoNota() {
        return descricaoNota;
    }

    public void setDescricao (String descricaoNota) {
        this.descricaoNota = descricaoNota;
    }

}

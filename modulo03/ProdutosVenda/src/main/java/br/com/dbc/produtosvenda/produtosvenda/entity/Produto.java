package br.com.dbc.produtosvenda.produtosvenda.entity;

import java.io.Serializable;
import javax.persistence.*;


    @Entity
    @Table(name = "PRODUTO")
    @NamedQueries({
    @NamedQuery(name = "PRODUTO.findAll", query = "SELECT p FROM PRODUTO p")})

public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ")
    @Column(name = "IDPRODUTO", nullable = false)
    private Long id;
    @Column(name = "DESCRICAOPRODUTO", nullable = false, length = 500)
    private String descricao;
    @Column(name = "UNIDADEDEMEDIDA", nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unMedida;
    
    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(Long id, String descricao,  UnidadeDeMedida unMedida) {
        this.id = id;
        this.descricao = descricao;
        this.unMedida = unMedida; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public UnidadeDeMedida getUnidadeDeMedida() {
        return unMedida;
    }

    public void setUnidadeDeMedida (UnidadeDeMedida unMedida) {
        this.unMedida = unMedida;
    }

}





package br.com.dbc.produtosvenda.produtosvenda.entity;

import java.io.Serializable;
import javax.persistence.*;

    @Entity
    @Table(name = "ITEMNOTA")
    @NamedQueries({
    @NamedQuery(name = "ITEMNOTA.findAll", query = "SELECT i FROM ITEMNOTA i")})

public class ItemNota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "ITEM_SEQ", sequenceName = "ITEM_SEQ")
    @Column(name = "IDITEM", nullable = false)
    private Long idItem;
    @Column(name = "QUANTIDADE", nullable = false)
    private Long quantidade;
    
    @ManyToOne(optional = false)
    private Nota idNota;
        
    @ManyToOne(optional = false)
    private Produto idProduto;
    
    public ItemNota() {
    }

    public ItemNota(Long idItem) {
        this.idItem = idItem;
    }

    public ItemNota(Long idItem, Long quantidade) {
        this.idItem = idItem;
        this.quantidade = quantidade;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setId(Long idItem) {
        this.idItem = idItem;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade (Long quantidade) {
        this.quantidade = quantidade;
    }

    public Nota getIdNota() {
        return idNota;
    }

    public void setIdNota(Nota idNota) {
        this.idNota = idNota;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    
}

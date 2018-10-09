/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.dbc.paiscidade.paiscidade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jaqueline.bonoto
 */
@Entity
@Table(name = "CIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findByIdcidade", query = "SELECT c FROM Cidade c WHERE c.idcidade = :idcidade")
    , @NamedQuery(name = "Cidade.findByNomecidade", query = "SELECT c FROM Cidade c WHERE c.nomecidade = :nomecidade")
    , @NamedQuery(name = "Cidade.findByCidadesigla", query = "SELECT c FROM Cidade c WHERE c.cidadesigla = :cidadesigla")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    private BigDecimal idcidade;
    @Basic(optional = false)
    @Column(name = "NOMECIDADE")
    private String nomecidade;
    @Column(name = "CIDADESIGLA")
    private String cidadesigla;
    @JoinColumn(name = "FK_IDESTADO", referencedColumnName = "IDESTADO")
    @ManyToOne
    private Estado fkIdestado;

    public Cidade() {
    }

    public Cidade(BigDecimal idcidade) {
        this.idcidade = idcidade;
    }

    public Cidade(BigDecimal idcidade, String nomecidade) {
        this.idcidade = idcidade;
        this.nomecidade = nomecidade;
    }

    public BigDecimal getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(BigDecimal idcidade) {
        this.idcidade = idcidade;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getCidadesigla() {
        return cidadesigla;
    }

    public void setCidadesigla(String cidadesigla) {
        this.cidadesigla = cidadesigla;
    }

    public Estado getFkIdestado() {
        return fkIdestado;
    }

    public void setFkIdestado(Estado fkIdestado) {
        this.fkIdestado = fkIdestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcidade != null ? idcidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idcidade == null && other.idcidade != null) || (this.idcidade != null && !this.idcidade.equals(other.idcidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.br.dbc.paiscidade.paiscidade.entity.Cidade[ idcidade=" + idcidade + " ]";
    }
    
}

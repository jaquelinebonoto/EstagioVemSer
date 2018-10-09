/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jaqueline.bonoto
 */
@Entity
@Table(name = "ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado_1.findAll", query = "SELECT e FROM Estado_1 e")
    , @NamedQuery(name = "Estado_1.findByIdestado", query = "SELECT e FROM Estado_1 e WHERE e.idestado = :idestado")
    , @NamedQuery(name = "Estado_1.findByNomeestado", query = "SELECT e FROM Estado_1 e WHERE e.nomeestado = :nomeestado")
    , @NamedQuery(name = "Estado_1.findByEstadosigla", query = "SELECT e FROM Estado_1 e WHERE e.estadosigla = :estadosigla")})
public class Estado_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDESTADO")
    private BigDecimal idestado;
    @Basic(optional = false)
    @Column(name = "NOMEESTADO")
    private String nomeestado;
    @Column(name = "ESTADOSIGLA")
    private String estadosigla;
    @JoinColumn(name = "FK_IDPAIS", referencedColumnName = "IDPAIS")
    @ManyToOne
    private Pais_1 fkIdpais;
    @OneToMany(mappedBy = "fkIdestado")
    private Collection<Cidade_1> cidadeCollection;

    public Estado_1() {
    }

    public Estado_1(BigDecimal idestado) {
        this.idestado = idestado;
    }

    public Estado_1(BigDecimal idestado, String nomeestado) {
        this.idestado = idestado;
        this.nomeestado = nomeestado;
    }

    public BigDecimal getIdestado() {
        return idestado;
    }

    public void setIdestado(BigDecimal idestado) {
        this.idestado = idestado;
    }

    public String getNomeestado() {
        return nomeestado;
    }

    public void setNomeestado(String nomeestado) {
        this.nomeestado = nomeestado;
    }

    public String getEstadosigla() {
        return estadosigla;
    }

    public void setEstadosigla(String estadosigla) {
        this.estadosigla = estadosigla;
    }

    public Pais_1 getFkIdpais() {
        return fkIdpais;
    }

    public void setFkIdpais(Pais_1 fkIdpais) {
        this.fkIdpais = fkIdpais;
    }

    @XmlTransient
    public Collection<Cidade_1> getCidadeCollection() {
        return cidadeCollection;
    }

    public void setCidadeCollection(Collection<Cidade_1> cidadeCollection) {
        this.cidadeCollection = cidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado_1)) {
            return false;
        }
        Estado_1 other = (Estado_1) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dbc.entity.Estado_1[ idestado=" + idestado + " ]";
    }
    
}

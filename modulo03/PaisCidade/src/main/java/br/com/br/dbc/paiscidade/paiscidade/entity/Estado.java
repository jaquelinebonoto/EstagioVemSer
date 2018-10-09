/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.br.dbc.paiscidade.paiscidade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findByIdestado", query = "SELECT e FROM Estado e WHERE e.idestado = :idestado")
    , @NamedQuery(name = "Estado.findByNomeestado", query = "SELECT e FROM Estado e WHERE e.nomeestado = :nomeestado")
    , @NamedQuery(name = "Estado.findByEstadosigla", query = "SELECT e FROM Estado e WHERE e.estadosigla = :estadosigla")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDESTADO")
    @SequenceGenerator(name = "ESTADO_SEQ", sequenceName = "ESTADO_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTADO_SEQ")
    private Long idestado;
    @Basic(optional = false)
    @Column(name = "NOMEESTADO")
    private String nomeestado;
    @Column(name = "ESTADOSIGLA")
    private String estadosigla;
    @JoinColumn(name = "FK_IDPAIS", referencedColumnName = "IDPAIS")
    @ManyToOne
    private Pais fkIdpais;
    @OneToMany(mappedBy = "fkIdestado")
    private Collection<Cidade> cidadeCollection;

    public Estado() {
    }

    public Estado(Long idestado) {
        this.idestado = idestado;
    }

    public Estado(Long idestado, String nomeestado) {
        this.idestado = idestado;
        this.nomeestado = nomeestado;
    }

    public Long getIdestado() {
        return idestado;
    }

    public void setIdestado(Long idestado) {
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

    public Pais getFkIdpais() {
        return fkIdpais;
    }

    public void setFkIdpais(Pais fkIdpais) {
        this.fkIdpais = fkIdpais;
    }

    @XmlTransient
    public Collection<Cidade> getCidadeCollection() {
        return cidadeCollection;
    }

    public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
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
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.br.dbc.paiscidade.paiscidade.entity.Estado[ idestado=" + idestado + " ]";
    }
    
}

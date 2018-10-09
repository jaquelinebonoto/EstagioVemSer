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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais_1.findAll", query = "SELECT p FROM Pais_1 p")
    , @NamedQuery(name = "Pais_1.findByIdpais", query = "SELECT p FROM Pais_1 p WHERE p.idpais = :idpais")
    , @NamedQuery(name = "Pais_1.findByNomepais", query = "SELECT p FROM Pais_1 p WHERE p.nomepais = :nomepais")
    , @NamedQuery(name = "Pais_1.findBySiglapais", query = "SELECT p FROM Pais_1 p WHERE p.siglapais = :siglapais")})
public class Pais_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPAIS")
    @SequenceGenerator(name = "PAIS_SEQ", sequenceName = "PAIS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIS_SEQ")
    private BigDecimal idpais;
    @Basic(optional = false)
    @Column(name = "NOMEPAIS")
    private String nomepais;
    @Column(name = "SIGLAPAIS")
    private String siglapais;
    @OneToMany(mappedBy = "fkIdpais")
    private Collection<Estado_1> estadoCollection;

    public Pais_1() {
    }

    public Pais_1(BigDecimal idpais) {
        this.idpais = idpais;
    }

    public Pais_1(BigDecimal idpais, String nomepais) {
        this.idpais = idpais;
        this.nomepais = nomepais;
    }

    public BigDecimal getIdpais() {
        return idpais;
    }

    public void setIdpais(BigDecimal idpais) {
        this.idpais = idpais;
    }

    public String getNomepais() {
        return nomepais;
    }

    public void setNomepais(String nomepais) {
        this.nomepais = nomepais;
    }

    public String getSiglapais() {
        return siglapais;
    }

    public void setSiglapais(String siglapais) {
        this.siglapais = siglapais;
    }

    @XmlTransient
    public Collection<Estado_1> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado_1> estadoCollection) {
        this.estadoCollection = estadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais_1)) {
            return false;
        }
        Pais_1 other = (Pais_1) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.dbc.entity.Pais_1[ idpais=" + idpais + " ]";
    }
    
}

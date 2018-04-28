/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosdonoso.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author propietario
 */
@Entity
@Table(name = "NATURALEZA", catalog = "", schema = "PRUEBAS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"DESCRIPCION"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naturaleza.findAll", query = "SELECT n FROM Naturaleza n")
    , @NamedQuery(name = "Naturaleza.findByIdnaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.idnaturaleza = :idnaturaleza")
    , @NamedQuery(name = "Naturaleza.findByDescripcion", query = "SELECT n FROM Naturaleza n WHERE n.descripcion = :descripcion")})
public class Naturaleza implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDNATURALEZA", nullable = false, precision = 0, scale = -127)
    private BigDecimal idnaturaleza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnaturaleza", fetch = FetchType.LAZY)
    private Collection<Movimientos> movimientosCollection;

    public Naturaleza() {
    }

    public Naturaleza(BigDecimal idnaturaleza) {
        this.idnaturaleza = idnaturaleza;
    }

    public Naturaleza(BigDecimal idnaturaleza, String descripcion) {
        this.idnaturaleza = idnaturaleza;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdnaturaleza() {
        return idnaturaleza;
    }

    public void setIdnaturaleza(BigDecimal idnaturaleza) {
        this.idnaturaleza = idnaturaleza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Movimientos> getMovimientosCollection() {
        return movimientosCollection;
    }

    public void setMovimientosCollection(Collection<Movimientos> movimientosCollection) {
        this.movimientosCollection = movimientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnaturaleza != null ? idnaturaleza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Naturaleza)) {
            return false;
        }
        Naturaleza other = (Naturaleza) object;
        if ((this.idnaturaleza == null && other.idnaturaleza != null) || (this.idnaturaleza != null && !this.idnaturaleza.equals(other.idnaturaleza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carlosdonoso.persistence.Naturaleza[ idnaturaleza=" + idnaturaleza + " ]";
    }
    
}

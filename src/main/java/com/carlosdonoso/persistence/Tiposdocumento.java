/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosdonoso.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
@Table(name = "TIPOSDOCUMENTO", catalog = "", schema = "PRUEBAS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"DESCRIPCION"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposdocumento.findAll", query = "SELECT t FROM Tiposdocumento t")
    , @NamedQuery(name = "Tiposdocumento.findByIdtipodocumento", query = "SELECT t FROM Tiposdocumento t WHERE t.idtipodocumento = :idtipodocumento")
    , @NamedQuery(name = "Tiposdocumento.findByDescripcion", query = "SELECT t FROM Tiposdocumento t WHERE t.descripcion = :descripcion")})
public class Tiposdocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPODOCUMENTO", nullable = false, precision = 0, scale = -127)
    private BigDecimal idtipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION", nullable = false, length = 30)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipodocumento", fetch = FetchType.LAZY)
    private List<Clientes> clientesList;

    public Tiposdocumento() {
    }

    public Tiposdocumento(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public Tiposdocumento(BigDecimal idtipodocumento, String descripcion) {
        this.idtipodocumento = idtipodocumento;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(BigDecimal idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipodocumento != null ? idtipodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposdocumento)) {
            return false;
        }
        Tiposdocumento other = (Tiposdocumento) object;
        if ((this.idtipodocumento == null && other.idtipodocumento != null) || (this.idtipodocumento != null && !this.idtipodocumento.equals(other.idtipodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carlosdonoso.persistence.Tiposdocumento[ idtipodocumento=" + idtipodocumento + " ]";
    }
    
}

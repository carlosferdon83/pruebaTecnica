/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosdonoso.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author propietario
 */
@Entity
@Table(name = "AUDITORIA", catalog = "", schema = "PRUEBAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByIdauditoria", query = "SELECT a FROM Auditoria a WHERE a.idauditoria = :idauditoria")
    , @NamedQuery(name = "Auditoria.findByIdmovimientos", query = "SELECT a FROM Auditoria a WHERE a.idmovimientos = :idmovimientos")
    , @NamedQuery(name = "Auditoria.findByIdcuentas", query = "SELECT a FROM Auditoria a WHERE a.idcuentas = :idcuentas")
    , @NamedQuery(name = "Auditoria.findByIdnaturaleza", query = "SELECT a FROM Auditoria a WHERE a.idnaturaleza = :idnaturaleza")
    , @NamedQuery(name = "Auditoria.findByValor", query = "SELECT a FROM Auditoria a WHERE a.valor = :valor")
    , @NamedQuery(name = "Auditoria.findByFechamovimiento", query = "SELECT a FROM Auditoria a WHERE a.fechamovimiento = :fechamovimiento")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAUDITORIA", nullable = false, precision = 0, scale = -127)
    private BigDecimal idauditoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMOVIMIENTOS", nullable = false)
    private BigInteger idmovimientos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCUENTAS", nullable = false)
    private BigInteger idcuentas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDNATURALEZA", nullable = false)
    private BigInteger idnaturaleza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR", nullable = false)
    private BigInteger valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAMOVIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamovimiento;

    public Auditoria() {
    }

    public Auditoria(BigDecimal idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Auditoria(BigDecimal idauditoria, BigInteger idmovimientos, BigInteger idcuentas, BigInteger idnaturaleza, BigInteger valor, Date fechamovimiento) {
        this.idauditoria = idauditoria;
        this.idmovimientos = idmovimientos;
        this.idcuentas = idcuentas;
        this.idnaturaleza = idnaturaleza;
        this.valor = valor;
        this.fechamovimiento = fechamovimiento;
    }

    public BigDecimal getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(BigDecimal idauditoria) {
        this.idauditoria = idauditoria;
    }

    public BigInteger getIdmovimientos() {
        return idmovimientos;
    }

    public void setIdmovimientos(BigInteger idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public BigInteger getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(BigInteger idcuentas) {
        this.idcuentas = idcuentas;
    }

    public BigInteger getIdnaturaleza() {
        return idnaturaleza;
    }

    public void setIdnaturaleza(BigInteger idnaturaleza) {
        this.idnaturaleza = idnaturaleza;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public Date getFechamovimiento() {
        return fechamovimiento;
    }

    public void setFechamovimiento(Date fechamovimiento) {
        this.fechamovimiento = fechamovimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauditoria != null ? idauditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idauditoria == null && other.idauditoria != null) || (this.idauditoria != null && !this.idauditoria.equals(other.idauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carlosdonoso.persistence.Auditoria[ idauditoria=" + idauditoria + " ]";
    }
    
}

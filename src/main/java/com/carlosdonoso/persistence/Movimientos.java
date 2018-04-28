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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "MOVIMIENTOS", catalog = "", schema = "PRUEBAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m")
    , @NamedQuery(name = "Movimientos.findByIdmovimientos", query = "SELECT m FROM Movimientos m WHERE m.idmovimientos = :idmovimientos")
    , @NamedQuery(name = "Movimientos.findByValor", query = "SELECT m FROM Movimientos m WHERE m.valor = :valor")
    , @NamedQuery(name = "Movimientos.findByFechamovimiento", query = "SELECT m FROM Movimientos m WHERE m.fechamovimiento = :fechamovimiento")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="SEQ_MOVIMIENTOS" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMIENTOS")
    @Column(name = "IDMOVIMIENTOS", nullable = false, precision = 38, scale = 0)
    private BigDecimal idmovimientos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR", nullable = false)
    private BigInteger valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAMOVIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamovimiento;
    @JoinColumn(name = "IDCUENTAS", referencedColumnName = "IDCUENTAS", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuentas idcuentas;
    @JoinColumn(name = "IDNATURALEZA", referencedColumnName = "IDNATURALEZA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Naturaleza idnaturaleza;

    public Movimientos() {
    }

    public Movimientos(BigDecimal idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public Movimientos(BigDecimal idmovimientos, BigInteger valor, Date fechamovimiento) {
        this.idmovimientos = idmovimientos;
        this.valor = valor;
        this.fechamovimiento = fechamovimiento;
    }

    public BigDecimal getIdmovimientos() {
        return idmovimientos;
    }

    public void setIdmovimientos(BigDecimal idmovimientos) {
        this.idmovimientos = idmovimientos;
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

    public Cuentas getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(Cuentas idcuentas) {
        this.idcuentas = idcuentas;
    }

    public Naturaleza getIdnaturaleza() {
        return idnaturaleza;
    }

    public void setIdnaturaleza(Naturaleza idnaturaleza) {
        this.idnaturaleza = idnaturaleza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimientos != null ? idmovimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.idmovimientos == null && other.idmovimientos != null) || (this.idmovimientos != null && !this.idmovimientos.equals(other.idmovimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carlosdonoso.persistence.Movimientos[ idmovimientos=" + idmovimientos + " ]";
    }
    
}

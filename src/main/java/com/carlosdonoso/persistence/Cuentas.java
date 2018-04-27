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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "CUENTAS", catalog = "", schema = "PRUEBAS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NUMEROCUENTA"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c")
    , @NamedQuery(name = "Cuentas.findByIdcuentas", query = "SELECT c FROM Cuentas c WHERE c.idcuentas = :idcuentas")
    , @NamedQuery(name = "Cuentas.findByNumerocuenta", query = "SELECT c FROM Cuentas c WHERE c.numerocuenta = :numerocuenta")
    , @NamedQuery(name = "Cuentas.findBySaldo", query = "SELECT c FROM Cuentas c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "Cuentas.findByFechaapertura", query = "SELECT c FROM Cuentas c WHERE c.fechaapertura = :fechaapertura")
    , @NamedQuery(name = "Cuentas.findByActiva", query = "SELECT c FROM Cuentas c WHERE c.activa = :activa")})
public class Cuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCUENTAS", nullable = false, precision = 0, scale = -127)
    private BigDecimal idcuentas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NUMEROCUENTA", nullable = false, length = 30)
    private String numerocuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO", nullable = false)
    private BigInteger saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAAPERTURA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaapertura;
    @Column(name = "ACTIVA")
    private Character activa;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes idcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuentas", fetch = FetchType.LAZY)
    private List<Movimientos> movimientosList;

    public Cuentas() {
    }

    public Cuentas(BigDecimal idcuentas) {
        this.idcuentas = idcuentas;
    }

    public Cuentas(BigDecimal idcuentas, String numerocuenta, BigInteger saldo, Date fechaapertura) {
        this.idcuentas = idcuentas;
        this.numerocuenta = numerocuenta;
        this.saldo = saldo;
        this.fechaapertura = fechaapertura;
    }

    public BigDecimal getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(BigDecimal idcuentas) {
        this.idcuentas = idcuentas;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public Date getFechaapertura() {
        return fechaapertura;
    }

    public void setFechaapertura(Date fechaapertura) {
        this.fechaapertura = fechaapertura;
    }

    public Character getActiva() {
        return activa;
    }

    public void setActiva(Character activa) {
        this.activa = activa;
    }

    public Clientes getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientes idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentas != null ? idcuentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.idcuentas == null && other.idcuentas != null) || (this.idcuentas != null && !this.idcuentas.equals(other.idcuentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carlosdonoso.persistence.Cuentas[ idcuentas=" + idcuentas + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CLIENTES", catalog = "", schema = "PRUEBAS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NUMERODOCUMENTO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByIdcliente", query = "SELECT c FROM Clientes c WHERE c.idcliente = :idcliente")
    , @NamedQuery(name = "Clientes.findByNumerodocumento", query = "SELECT c FROM Clientes c WHERE c.numerodocumento = :numerodocumento")
    , @NamedQuery(name = "Clientes.findByPrimerapellido", query = "SELECT c FROM Clientes c WHERE c.primerapellido = :primerapellido")
    , @NamedQuery(name = "Clientes.findBySegundoapellido", query = "SELECT c FROM Clientes c WHERE c.segundoapellido = :segundoapellido")
    , @NamedQuery(name = "Clientes.findByPrimernombre", query = "SELECT c FROM Clientes c WHERE c.primernombre = :primernombre")
    , @NamedQuery(name = "Clientes.findBySegundonombre", query = "SELECT c FROM Clientes c WHERE c.segundonombre = :segundonombre")
    , @NamedQuery(name = "Clientes.findByCorreo", query = "SELECT c FROM Clientes c WHERE c.correo = :correo")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENTE", nullable = false, precision = 0, scale = -127)
    private BigDecimal idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NUMERODOCUMENTO", nullable = false, length = 30)
    private String numerodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRIMERAPELLIDO", nullable = false, length = 30)
    private String primerapellido;
    @Size(max = 30)
    @Column(name = "SEGUNDOAPELLIDO", length = 30)
    private String segundoapellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRIMERNOMBRE", nullable = false, length = 30)
    private String primernombre;
    @Size(max = 30)
    @Column(name = "SEGUNDONOMBRE", length = 30)
    private String segundonombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CORREO", nullable = false, length = 40)
    private String correo;
    @JoinColumn(name = "IDTIPODOCUMENTO", referencedColumnName = "IDTIPODOCUMENTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tiposdocumento idtipodocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente", fetch = FetchType.LAZY)
    private List<Cuentas> cuentasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclientes", fetch = FetchType.LAZY)
    private List<Usuarios> usuariosList;

    public Clientes() {
    }

    public Clientes(BigDecimal idcliente) {
        this.idcliente = idcliente;
    }

    public Clientes(BigDecimal idcliente, String numerodocumento, String primerapellido, String primernombre, String correo) {
        this.idcliente = idcliente;
        this.numerodocumento = numerodocumento;
        this.primerapellido = primerapellido;
        this.primernombre = primernombre;
        this.correo = correo;
    }

    public BigDecimal getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(BigDecimal idcliente) {
        this.idcliente = idcliente;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Tiposdocumento getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(Tiposdocumento idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    @XmlTransient
    public List<Cuentas> getCuentasList() {
        return cuentasList;
    }

    public void setCuentasList(List<Cuentas> cuentasList) {
        this.cuentasList = cuentasList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carlosdonoso.persistence.Clientes[ idcliente=" + idcliente + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosdonoso.prueba;

import com.carlosdonoso.persistence.Cuentas;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author propietario
 */
@Stateless
public class CuentasFacade extends AbstractFacade<Cuentas> {

    @PersistenceContext(unitName = "com.carlosDonoso_carlosDonoso_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentasFacade() {
        super(Cuentas.class);
    }
    
    public Cuentas obtenerSaldoCuenta(BigDecimal idCuenta){
        Cuentas cuenta = null;
        try{
            Query query = getEntityManager().createQuery("select c from Cuentas c where c.idcuentas = ?1");
            query.setParameter(1,idCuenta);
            cuenta = (Cuentas) query.getSingleResult();
        }catch(Exception ex){
            System.out.println("Un error ha ocurrido "+ex.getMessage());
        }
        return cuenta;
    }

    
}

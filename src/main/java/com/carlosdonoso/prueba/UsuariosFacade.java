/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosdonoso.prueba;

import com.carlosdonoso.persistence.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author propietario
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "com.carlosDonoso_carlosDonoso_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios validarUsuario(String usuario, String clave){
        Usuarios usuarios = null;
        try{
            Query query = getEntityManager().createQuery("select u from Usuarios u where u.login= :usuario and u.pass = :clave");
            query.setParameter("usuario", usuario);
            query.setParameter("clave", clave);
            usuarios = (Usuarios) query.getSingleResult();
        }catch(Exception ex){
            System.out.println("Un error ha ocurrido "+ex.getMessage());
        }
        return usuarios;
    }
    
}

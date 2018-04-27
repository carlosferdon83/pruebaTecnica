/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosdonoso.prueba;

import com.carlosdonoso.persistence.Tiposdocumento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author propietario
 */
@Stateless
public class TiposdocumentoFacade extends AbstractFacade<Tiposdocumento> {

    @PersistenceContext(unitName = "com.carlosDonoso_carlosDonoso_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposdocumentoFacade() {
        super(Tiposdocumento.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.TFAitcatramss.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.TFAitcatramss.entidades.Estado;

/**
 *
 * @author lel
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "TFAitcatramssPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    
}

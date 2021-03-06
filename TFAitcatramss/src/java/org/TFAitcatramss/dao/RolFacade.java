/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.TFAitcatramss.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.TFAitcatramss.entidades.Rol;

/**
 *
 * @author lel
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> {

    @PersistenceContext(unitName = "TFAitcatramssPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    
    // NUESTRO CODIGO
    
    public List<Rol> listarRol() {
        List<Rol> lista = null;
        try {
            Query q = em.createNamedQuery("Rol.findAll");
            lista = q.getResultList();
            //System.out.println("asdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}

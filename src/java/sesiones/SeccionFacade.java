/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.Seccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luigi
 */
@Stateless
public class SeccionFacade extends AbstractFacade<Seccion> {

    @PersistenceContext(unitName = "Integrador1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeccionFacade() {
        super(Seccion.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.Funcion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luigi
 */
@Stateless
public class FuncionFacade extends AbstractFacade<Funcion> {

    @PersistenceContext(unitName = "Integrador1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionFacade() {
        super(Funcion.class);
    }
    
}

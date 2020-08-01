/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TipoArticulo;

/**
 *
 * @author USUARIO
 */
@Stateless
public class TipoArticuloFacade extends AbstractFacade<TipoArticulo> {

    @PersistenceContext(unitName = "sistemaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoArticuloFacade() {
        super(TipoArticulo.class);
    }
    
}

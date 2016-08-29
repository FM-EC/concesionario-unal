/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Provider;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIAN
 */
@Stateless
public class ProviderFacade extends AbstractFacade<Provider> implements ProviderFacadeLocal {

    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
   
    public ProviderFacade() {
        super(Provider.class);
    }

    @Override
    public List<Provider> findAll() {
        try {
            return em.createNamedQuery("Provider.findAll", Provider.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}

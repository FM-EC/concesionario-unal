/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Cars;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIAN
 */
@Stateless
public class CarsFacade extends AbstractFacade<Cars> implements CarsFacadeLocal {

    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public boolean createCar(Cars entity) {
        try {
            em.persist(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public CarsFacade() {
        super(Cars.class);
    }
    
}

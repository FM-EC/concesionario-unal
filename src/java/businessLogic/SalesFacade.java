/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Sales;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIAN
 */
@Stateless
public class SalesFacade extends AbstractFacade<Sales> implements SalesFacadeLocal {

    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Sales> findAll() {
        List<Sales> cars = new ArrayList<>();
        try {
            cars = em.createNamedQuery("Sales.findAll").getResultList();
        } catch (Exception e) {
            em.close();
        } finally {
            em.close();
        }
        return cars;
          
    }
 
    public SalesFacade() {
        super(Sales.class);
    }
    
}

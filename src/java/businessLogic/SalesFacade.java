/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Profile;
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
        List<Sales> sales = new ArrayList<>();
        try {
            sales = em.createNamedQuery("Sales.findAll").getResultList();
        } catch (Exception e) {
            em.close();
        } finally {
            em.close();
        }
        return sales;          
    }
 
    @Override
    public Sales createSale(Sales entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public List<Sales> findByIdUser(Profile id) {
        List<Sales> sales = new ArrayList<>();
        try {
            sales = em.createNamedQuery("Sales.findByIdUser")
                    .setParameter("idUser", id)
                    .getResultList();
            return sales;
        } catch (Exception e) {
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
    
    public SalesFacade() {
        super(Sales.class);
    }

    
    
}

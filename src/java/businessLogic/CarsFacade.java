/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Cars;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIAN
 */
@Stateless
public class CarsFacade extends AbstractFacade<Cars> implements CarsFacadeLocal {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("concesionarioPU");
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

    @Override
    public List<Cars> findAll() {
        EntityManager em = emf.createEntityManager();
        List <Cars> cars= new ArrayList<>();
        try {
            cars = em.createNamedQuery("Cars.findAll").getResultList();
        } catch (Exception e) {
            em.close();
        } finally {
            em.close();
        }
        return cars;
        //return dao.findAll();
     
    }

    public CarsFacade() {
        super(Cars.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Cars;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
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
    
    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;
    
    @PreDestroy
    public void knockdown(){
        em.close();
    }
    
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
        List<Cars> cars= new ArrayList<>();
        try {
            cars = em.createNamedQuery("Cars.findAll", Cars.class).getResultList();
        } catch (Exception e) {
            em.close();
        } 
        return cars;
            
    }
    
    @Override
    public boolean createCars(List<Cars> cars) {
        cars.forEach((it)->{
            try {
                em.merge(it);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return true;
    }
    
    public CarsFacade() {
        super(Cars.class);
    }

    
    
}

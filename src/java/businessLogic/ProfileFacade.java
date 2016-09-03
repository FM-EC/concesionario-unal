/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIAN
 */
@Stateless
public class ProfileFacade extends AbstractFacade<Profile> implements ProfileFacadeLocal {

    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

    public Integer createProfile(String theName, String theLastName, String thePhone, String theCity, String theAddress, String theEmail)
    {
        Profile theProfile = new Profile();
        theProfile.setName(theName);
        theProfile.setLastName(theLastName);
        theProfile.setPhone(thePhone);
        theProfile.setAddress(theAddress);
        theProfile.setCity(theCity);
        
        
        try{em.persist(theProfile);}
        catch (Exception e){}
        
        /*em.getTransaction().begin();
        try {
            em.persist(theProfile);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }*/
        
       // em.close();
        //em.clear();
    
        Profile theProfile2 = new Profile();
        theProfile2 = getProfbyName(theName);
        
        
        return theProfile2.getIdUser();
    }

    @Override
    public List<Profile> findAll() {
        try {
            return em.createNamedQuery("Profile.findAll", Profile.class).getResultList();                    
        } catch (Exception e) {
            return null;
        }
    }
    
 
    
    public Profile getProfbyName(String name)
    {
        try {
            return em.createNamedQuery("Profile.findByName", Profile.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public ProfileFacade() {
        super(Profile.class);
    }

    @Override
    public Profile findById(int id) {
        try {
            return em.createNamedQuery("Profile.findByIdUser", Profile.class)
                    .setParameter("idUser", id)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}

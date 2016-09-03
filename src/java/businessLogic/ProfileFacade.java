/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Profile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author FABIAN
 */

//@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
public class ProfileFacade extends AbstractFacade<Profile> implements ProfileFacadeLocal {

    //private EntityManagerFactory entityManagerFactory;
    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;
    
    //@Resource
   //private UserTransaction userTransaction;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

    public Integer createProfile(String theName, String theLastName, String theIdCard ,String thePhone, String theCity, String theAddress, String theEmail)
    {
        Profile theProfile = new Profile();
        theProfile.setName(theName);
        theProfile.setLastName(theLastName);
        theProfile.setIdCard(theIdCard);
        theProfile.setPhone(thePhone);
        theProfile.setAddress(theAddress);
        theProfile.setCity(theCity);
    
                // 
           try{em.persist(theProfile);}
            //
           catch (Exception e){e.printStackTrace();}
            
          
        
        Profile theProfile2 = new Profile();
        theProfile2 = getProfbyIdCard(theIdCard);
        return theProfile2.getIdUser();
    }
    
    
   
    
    public Profile getProfbyIdCard(String theIdCard)
    {
        try {
            return em.createNamedQuery("Profile.findByIdCard", Profile.class)
                    .setParameter("idCard", theIdCard)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
   
   
   //@Override
    public Profile findById(int id) {
        try {
            return em.createNamedQuery("Profile.findByIdUser", Profile.class)
                    .setParameter("idUser", id)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public ProfileFacade() {
        super(Profile.class);
    }
    
}

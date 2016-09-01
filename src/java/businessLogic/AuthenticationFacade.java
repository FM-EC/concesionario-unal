/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Authentication;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIAN
 */
@Stateless
public class AuthenticationFacade extends AbstractFacade<Authentication> implements AuthenticationFacadeLocal {

    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
     public String createAuth(String theEmail, String theUsername, String thePass, Integer theId)
    {
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        Authentication theAuth = new Authentication();
        theAuth.setIdUser(theId);
        theAuth.setEmail(theEmail);
        theAuth.setPassword(thePass);
        theAuth.setUsername(theUsername);
        theAuth.setLastAccess(dt);
        
        System.out.println(theAuth.getEmail() + theAuth.getIdUser());
        em.clear();
        try{em.persist(theAuth);
        }
        catch(Exception e)
        {System.out.println(e);}
        
        
       /* em.getTransaction().begin();
        try {
            em.persist(theAuth);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }*/
        return theAuth.getEmail();
    }
     
    @Override
    // Authenticate users function using the entity autentication
    public boolean authenticate(String email, String password){
        System.out.println(email);
        Authentication user = getUserByEmail(email);
        if(user == null){ return false; }
        return user.getPassword().equals(password);
    }
    
    // Method to find the user by email coming from loginBean
    public Authentication getUserByEmail(String email){
        try {
            return em.createNamedQuery("Authentication.findByEmail", Authentication.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
    
   
    public AuthenticationFacade() {
        super(Authentication.class);
    }

    
    
}

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

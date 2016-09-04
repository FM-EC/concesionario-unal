/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Client;
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
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("concesionarioPU");
    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try {
            clients = em.createNamedQuery("Client.findAll", Client.class).getResultList();
        } catch (Exception e) {
            em.close();
        }
        return clients;
    }
    
    public Integer createClient(String theName, String theLastName, String theEmail ,String thePhone, String theAddress)
    {
        Client theClient = new Client();
        theClient.setName(theName);
        theClient.setLastName(theLastName);
        theClient.setEmail(theEmail);
        theClient.setPhone(thePhone);
        theClient.setAddress(theAddress);
        
        try{em.persist(theClient);}
            //
           catch (Exception e){e.printStackTrace();}
        
        Client theClient2 = new Client();
        theClient2 = getProfbyEmail(theEmail);
        return theClient2.getIdClient();
    }
    
    public Client getProfbyEmail(String theEmail)
    {
        try {
            return em.createNamedQuery("Client.findByEmail", Client.class)
                    .setParameter("email", theEmail)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public ClientFacade() {
        super(Client.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIAN
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    public Integer createClient(String theName, String theLastName, String theEmail ,String thePhone, String theAddress);
    
    int count();
    
}

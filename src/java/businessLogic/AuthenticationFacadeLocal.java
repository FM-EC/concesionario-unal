/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Authentication;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIAN
 */
@Local
public interface AuthenticationFacadeLocal {

    void create(Authentication authentication);

    void edit(Authentication authentication);

    void remove(Authentication authentication);

    public boolean authenticate(String email, String password);
    
    Authentication find(Object id);

    List<Authentication> findAll();

    List<Authentication> findRange(int[] range);

    int count();
    
}

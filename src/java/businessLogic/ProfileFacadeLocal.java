/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Profile;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIAN
 */
@Local
public interface ProfileFacadeLocal {

    void create(Profile profile);

    void edit(Profile profile);

    void remove(Profile profile);

    Profile find(Object id);
    
    
    List<Profile> findAll();

    List<Profile> findRange(int[] range);

    Profile findById(int id);
    
    int count();
    
    Integer createProfile(String theName, String theLastName, String theIdCard ,String thePhone, String theCity, String theAddress, String theEmail);
    
}

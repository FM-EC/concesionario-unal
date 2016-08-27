/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Purchases;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIAN
 */
@Local
public interface PurchasesFacadeLocal {

    void create(Purchases purchases);

    void edit(Purchases purchases);

    void remove(Purchases purchases);

    Purchases find(Object id);

    List<Purchases> findAll();

    List<Purchases> findRange(int[] range);

    int count();
    
}

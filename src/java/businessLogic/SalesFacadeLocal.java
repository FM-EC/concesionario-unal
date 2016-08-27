/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Sales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FABIAN
 */
@Local
public interface SalesFacadeLocal {

    void create(Sales sales);

    void edit(Sales sales);

    void remove(Sales sales);

    Sales find(Object id);

    List<Sales> findAll();

    List<Sales> findRange(int[] range);

    int count();
    
}

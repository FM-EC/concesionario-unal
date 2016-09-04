/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import javax.ejb.EJB;
import businessLogic.CarsFacade;
import businessLogic.CarsFacadeLocal;
import businessLogic.ProfileFacadeLocal;
import businessLogic.SalesFacadeLocal;
import businessLogic.sessionManagement.SessionUtils;
import dataAccess.Cars;
import dataAccess.Profile;
import dataAccess.Sales;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alvaro
 */


@Named(value = "sellersalesbean")
@Dependent
public class SellersalesBean {
    @EJB
    private SalesFacadeLocal ejb;
    
    @EJB 
    private ProfileFacadeLocal ejbProf;
    
    public SellersalesBean()
    {        
    }
    
     public List <Sales> findAll(){
         
         HttpSession session = SessionUtils.getSession();
         int theUserId = (int)  session.getAttribute("idUser");
         
         //int theUserId = 1;
         Profile theProf = new Profile();
         theProf = ejbProf.findById(theUserId);
         
         System.out.println("user: "+ theProf.getIdCard() + "nombre:" + theProf.getName());
         List<Sales> theSales = new ArrayList<>();
         
         theSales = ejb.findByIdUser(theProf);
         System.out.println("lenght: " + theSales.isEmpty());
         for (Sales  s: theSales){
            System.out.println(s.toString());
        }
        return theSales;         
     }
     
     public float getCommission(Sales theSale)
     {
         int theId = theSale.getIdSales();
         return ejb.getCommission(theId);
     }
     
    
     
}

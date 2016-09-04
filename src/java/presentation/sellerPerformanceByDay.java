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
import java.util.Date;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alvaro
 */

//@Named(value = "sellerperformancebyday")
//@ManagedBean
//
//@Named(value = "sellersalesbean")
@ManagedBean
@ViewScoped
@Dependent
public class sellerPerformanceByDay {
    @EJB
    private SalesFacadeLocal ejb;

   
    @EJB 
    private ProfileFacadeLocal ejbProf;
     
    
    Date dt;
    float dayTotalValue;
    List<Sales> theRequiredOnes;

    public float getDayTotalValue() {
        return dayTotalValue;
    }

    public void setDayTotalValue(float dayTotalValue) {
        this.dayTotalValue = dayTotalValue;
    }
    
    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
     
    //java.util.Date dt = new java.util.Date();
    

    public List<Sales> getTheRequiredOnes() {
        return theRequiredOnes;
    }

    public void setTheRequiredOnes(List<Sales> theRequiredOnes) {
        this.theRequiredOnes = theRequiredOnes;
    }
    
    public void findRequired()
    {
        HttpSession session = SessionUtils.getSession();
         int theUserId = (int)  session.getAttribute("idUser");
         float theTotalCommission;
         //int theUserId = 1;
         Profile theProf = new Profile();
         theProf = ejbProf.findById(theUserId);
         
         System.out.println("user: "+ theProf.getIdCard() + "nombre:" + theProf.getName());
         List<Sales> theSales = new ArrayList<>();
         List<Sales> theRequiredOnes1 = new ArrayList<>();
         
         theSales = ejb.findByIdUser(theProf);
         //setDt(dt);
         System.out.println(dt);
        // System.out.println("lenght: " + theSales.isEmpty());
         if(theSales != null)
         {
             System.out.print("sales not null");
            for (Sales  s: theSales){
                if(s.getSaleDate().getYear() == dt.getYear() && s.getSaleDate().getMonth() == dt.getMonth() && s.getSaleDate().getDay() == dt.getDay())
                {
                    theRequiredOnes1.add(s);
                    //System.out.print("entramos esta vez");
                }
            }
            if(theRequiredOnes1.isEmpty())
            {
                System.out.print("NO hay ventas de este dia");
                List<Sales> theEmptyOne = new ArrayList<>();
                setTheRequiredOnes(theEmptyOne);
                setDayTotalValue(0);
            }
            else
            {
                System.out.print("SI hay ventas de este dia");
                theTotalCommission = ejb.getComissionPerDay(theRequiredOnes1);
                System.out.println(theRequiredOnes1.size());

                setTheRequiredOnes(theRequiredOnes1);
                System.out.println(theRequiredOnes.size());
                setDayTotalValue(theTotalCommission);
                for(Sales w: theRequiredOnes1)
                {
                    System.out.println(w);
                }
            }
            
         }
         
         else{System.out.println("Sales vacia");
             List<Sales> theEmptyOne = new ArrayList<>();
             setTheRequiredOnes(theEmptyOne);
             setDayTotalValue(0);
         }
         
         
        click();
        System.out.println(dt);
        
      //  return theSales;         
    }
    
    public List<Integer> waka()
    {
        List <Integer>waka = new ArrayList();
        return waka;
    }
    
    public List <Sales> getThisDaySales()
    {
        HttpSession session = SessionUtils.getSession();
         int theUserId = (int)  session.getAttribute("idUser");
         float theTotalCommission;
         //int theUserId = 1;
         Profile theProf = new Profile();
         theProf = ejbProf.findById(theUserId);
         
         System.out.println("user: "+ theProf.getIdCard() + "nombre:" + theProf.getName());
         List<Sales> theSales = new ArrayList<>();
         List<Sales> theRequiredOnes1 = new ArrayList<>();
         
         theSales = ejb.findByIdUser(theProf);
         
         if(theSales != null)
         {
             for (Sales  s: theSales){
                if(s.getSaleDate().getYear() == dt.getYear() && s.getSaleDate().getMonth() == dt.getMonth() && s.getSaleDate().getDay() == dt.getDay())
                {
                    theRequiredOnes1.add(s);
                    //System.out.print("entramos esta vez");
                }
            }
             
             return theRequiredOnes1;
         }
         else
         {
             List<Sales> theEmptyOne = new ArrayList<>();
             return theEmptyOne;
         }
    }
    
    
    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("chooseday:display");
        requestContext.execute("PF('dlg').show()");
    }
}

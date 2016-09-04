/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;


import javax.ejb.EJB;
import businessLogic.CarsFacade;
import businessLogic.CarsFacadeLocal;
import dataAccess.Cars;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alvaro
 */


@ManagedBean
@Dependent        
@SessionScoped
public class UpdateCarBean {
    
    private int theId;
    private String theCarriagePlate; //the original one
    private String brand;
    private float salesPrice;
    private float purchasePrice;
    private String model;
    private String color;
    private String carriagePlate;
    private String chasisNumber;
    private String engineNumber;
    private String transmissionType;
    
    @EJB 
    private CarsFacadeLocal ejb;
    
    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    //private int idProvider;
    
    
    
    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarriagePlate() {
        return carriagePlate;
    }

    public void setCarriagePlate(String carriagePlate) {
        this.carriagePlate = carriagePlate;
    }

    public String getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(String chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
    
      public String getTheCarriagePlate() {
        return theCarriagePlate;
    }

    public void setTheCarriagePlate(String theCarriagePlate) {
        this.theCarriagePlate = theCarriagePlate;
    }

    public int getTheId() {
        return theId;
    }

    public void setTheId(int theId) {
        this.theId = theId;
    }

   
    public CarsFacadeLocal getEjb() {
        return ejb;
    }

    public void setEjb(CarsFacadeLocal ejb) {
        this.ejb = ejb;
    }
    
    
    public UpdateCarBean(){}
    
    
    public void fillTheCar()
    {
        System.out.println(theCarriagePlate);
        
        Cars theCar = ejb.getTheCar(theCarriagePlate);
        setTheId(theCar.getIdCar());
        setChasisNumber(theCar.getChasisNumber());
        setEngineNumber(theCar.getEngineNumber());
        setColor(theCar.getColor());
        setTransmissionType(theCar.getTransmissionType());
        setPurchasePrice(theCar.getPurchasePrice());
        
        
        System.out.println(theCar.getEngineNumber());
        click();
            
        
    }
    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("theCar:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    public void updateCar()
    {
       boolean changed = ejb.update(theCarriagePlate, salesPrice);
       System.out.println(changed);
        click1();
    }
    
    public void click1() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("modifiedCar:displayModified");
        requestContext.execute("PF('dlg1').show()");
    }
}
